package com.bungy.twindlingtweaks.block.entity.custom.special_block_entity;

import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import com.bungy.twindlingtweaks.block.entity.custom.block_entity.CrusherBlockEntity;
import com.bungy.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;
import com.bungy.twindlingtweaks.recipes.be_recipes.input.PasteurizerRecipeInput;
import com.bungy.twindlingtweaks.screen.crusher.CrusherMenu;
import com.bungy.twindlingtweaks.screen.pasteurizer.PasteurizerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.bungy.twindlingtweaks.util.block_entity_util.PasteurizerEffectMap.EFFECT_ITEM_MAP;

public class PasteurizerBlockEntity extends BlockEntity {

    @Nullable
    private CompoundTag customPersistentData;

    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private BlockCapabilityCache<IItemHandler, @Nullable Direction> handlerCache;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public PasteurizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PASTEURIZER_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> progress;
                    case 1 -> maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> progress = value;
                    case 1 -> maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ContainerData getData() {
        return data;
    }

    @Nullable
    public IItemHandler getItemHandler(@Nullable Direction side) {
        if (handlerCache != null) {
            IItemHandler cap = handlerCache.getCapability();
            if (cap != null) return cap;
        }
        return this.itemHandler;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (level instanceof ServerLevel level) {
            handlerCache = BlockCapabilityCache.create(
                    Capabilities.ItemHandler.BLOCK,
                    level,
                    this.worldPosition,
                    Direction.NORTH
            );
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (handlerCache != null) handlerCache.getCapability();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        if (customPersistentData != null) {
            tag.put("NeoForgeData", customPersistentData.copy());
        }
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("pasteurizer.progress", progress);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("NeoForgeData", 10)) {
            customPersistentData = tag.getCompound("NeoForgeData");
        }
        if (tag.contains("inventory", 10)) {
            CompoundTag invTag = tag.getCompound("inventory");
            itemHandler.deserializeNBT(registries, invTag);
        }
        progress = tag.getInt("pasteurizer.progress");
    }

    public Component getDisplayName() {
        return Component.translatable("block.twindlingtweaks.pasteurizer");
    }

    public void openMenu(ServerPlayer player) {
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return PasteurizerBlockEntity.this.getDisplayName();
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inv, Player pl) {
                return new PasteurizerMenu(id, inv, PasteurizerBlockEntity.this);
            }
        }, buf -> {
            buf.writeBlockPos(this.getBlockPos());
        });
    }

    public boolean interact(ServerPlayer player) {
        openMenu(player);
        return true;
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inv.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(level, worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PasteurizerBlockEntity entity) {
        if (entity.hasRecipe()) {
            entity.progress++;
            setChanged(level, pos, state);
            if (entity.progress > entity.maxProgress) {
                entity.craftItem();
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private boolean hasRecipe() {
        ItemStack input = itemHandler.getStackInSlot(0);
        if (input.isEmpty()) return false;

        Player nearestPlayer = level.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 5, false);
        ItemStack output;

        if (nearestPlayer != null) {
            // Collect matching effects
            List<?> matching = nearestPlayer.getActiveEffects().stream()
                    .map(e -> e.getEffect())
                    .filter(EFFECT_ITEM_MAP::containsKey)
                    .toList();

            if (matching.size() == 1) {
                output = new ItemStack(EFFECT_ITEM_MAP.get(matching.get(0)));
            } else {
                // No effect or multiple effects => return input itself
                output = input.copy();
            }
        } else {
            output = input.copy();
        }

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output.getItem());
    }

    private void craftItem() {
        ItemStack input = itemHandler.getStackInSlot(0);
        if (input.isEmpty()) return;

        Player nearestPlayer = level.getNearestPlayer(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ(), 5, false);
        ItemStack output;

        if (nearestPlayer != null) {
            List<?> matching = nearestPlayer.getActiveEffects().stream()
                    .map(e -> e.getEffect())
                    .filter(EFFECT_ITEM_MAP::containsKey)
                    .toList();

            if (matching.size() == 1) {
                output = new ItemStack(EFFECT_ITEM_MAP.get(matching.get(0)));
            } else {
                output = input.copy();
            }
        } else {
            output = input.copy();
        }

        itemHandler.extractItem(0, 1, false);
        itemHandler.setStackInSlot(1, new ItemStack(
                output.getItem(),
                itemHandler.getStackInSlot(1).getCount() + output.getCount()
        ));
        resetProgress();
    }

    private Optional<Item> getEffectBasedResult(Player player) {
        List<Holder<MobEffect>> matching = player.getActiveEffects().stream()
                .map(MobEffectInstance::getEffect)
                .filter(EFFECT_ITEM_MAP::containsKey)
                .toList();

        if (matching.size() == 1) {
            return Optional.of(EFFECT_ITEM_MAP.get(matching.get(0)));
        }

        return Optional.empty();
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return itemHandler.getStackInSlot(1).isEmpty() || itemHandler.getStackInSlot(1).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return itemHandler.getStackInSlot(1).getCount() + count <= itemHandler.getStackInSlot(1).getMaxStackSize();
    }
}