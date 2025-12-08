package com.bungy.twindlingtweaks.block.entity.custom.block_entity;

import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import com.bungy.twindlingtweaks.recipes.be_recipes.CrusherRecipe;
import com.bungy.twindlingtweaks.recipes.be_recipes.input.CrusherRecipeInput;
import com.bungy.twindlingtweaks.screen.crusher.CrusherMenu;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

public class CrusherBlockEntity extends BlockEntity {
    @Nullable
    private CompoundTag customPersistentData;

    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    // Capability cache for fast repeated access (one instance per BE)
    private BlockCapabilityCache<IItemHandler, @Nullable Direction> handlerCache;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 46;

    public CrusherBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHER_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return CrusherBlockEntity.this.progress;
                    case 1: return CrusherBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CrusherBlockEntity.this.progress = value; break;
                    case 1: CrusherBlockEntity.this.maxProgress = value; break;
                }
            }
            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public ContainerData getData() {
        return this.data;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (level instanceof ServerLevel level) {
            this.handlerCache = BlockCapabilityCache.create(
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
        // Invalidate cache when removed
        if (handlerCache != null) {
            handlerCache.getCapability();
        }
    }

    @Nullable
    public IItemHandler getItemHandler(@Nullable Direction side) {
        if (handlerCache != null) {
            IItemHandler cap = handlerCache.getCapability();
            if (cap != null) return cap;
        }
        return this.itemHandler;
    }

    // You no longer override getCapability; instead rely on the capability cache / direct querying

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        if (customPersistentData != null) {
            tag.put("NeoForgeData", customPersistentData.copy());
        }
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("crusher.progress", progress);
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
        progress = tag.getInt("crusher.progress");
    }

    public Component getDisplayName() {
        return Component.translatable("block.twindlingtweaks.crusher");
    }

    public void openMenu(ServerPlayer player) {
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return CrusherBlockEntity.this.getDisplayName();
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inv, Player pl) {
                return new CrusherMenu(id, inv, CrusherBlockEntity.this);
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
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CrusherBlockEntity entity) {
        if (hasRecipe(entity)) {
            entity.progress++;
            setChanged(level, pos, state);
            if (entity.progress > entity.maxProgress) {
                craftItem(entity);
            }
        } else {
            entity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private static boolean hasRecipe(CrusherBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(
                entity.itemHandler.getStackInSlot(0),
                entity.itemHandler.getStackInSlot(1)
        );
        CrusherRecipeInput input = new CrusherRecipeInput(inv);

        assert level != null;
        java.util.Optional<CrusherRecipe> match = level.getRecipeManager()
                .getRecipeFor(CrusherRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(entity.itemHandler)
                && canInsertItemIntoOutputSlot(
                entity.itemHandler,
                match.get().getResultItem(level.registryAccess())
        );
    }

    private static void craftItem(CrusherBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(
                entity.itemHandler.getStackInSlot(0),
                entity.itemHandler.getStackInSlot(1)
        );
        CrusherRecipeInput input = new CrusherRecipeInput(inv);

        assert level != null;
        java.util.Optional<CrusherRecipe> match = level.getRecipeManager()
                .getRecipeFor(CrusherRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        if (match.isPresent()) {
            ItemStack hammer = entity.itemHandler.getStackInSlot(0);
            if (hammer.isDamageableItem()) {
                hammer.setDamageValue(hammer.getDamageValue() + 10);
                if (hammer.getDamageValue() >= hammer.getMaxDamage()) {
                    hammer.shrink(1);
                }
                entity.itemHandler.extractItem(1, 1, false);
                entity.itemHandler.setStackInSlot(2, new ItemStack(
                        match.get().getResultItem(level.registryAccess()).getItem(),
                        entity.itemHandler.getStackInSlot(2).getCount() + 1
                ));
                entity.resetProgress();
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(ItemStackHandler handler, ItemStack output) {
        return handler.getStackInSlot(2).isEmpty()
                || handler.getStackInSlot(2).getItem() == output.getItem();
    }

    private static boolean canInsertAmountIntoOutputSlot(ItemStackHandler handler) {
        return handler.getStackInSlot(2).getCount() < handler.getStackInSlot(2).getMaxStackSize();
    }
}