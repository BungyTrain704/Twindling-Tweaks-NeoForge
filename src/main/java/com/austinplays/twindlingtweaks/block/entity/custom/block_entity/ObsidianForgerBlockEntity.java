package com.austinplays.twindlingtweaks.block.entity.custom.block_entity;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.recipes.be_recipes.ObsidianForgerRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.input.ObsidianForgerRecipeInput;
import com.austinplays.twindlingtweaks.screen.obsidian_forger.ObsidianForgerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.LivingEntity;
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

import java.util.Optional;

public class ObsidianForgerBlockEntity extends BlockEntity {
    @Nullable
    private CompoundTag customPersistentData;

    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private BlockCapabilityCache<IItemHandler, @Nullable Direction> handlerCache;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public ObsidianForgerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OBSIDIAN_FORGER_BLOCK_ENTITY.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ObsidianForgerBlockEntity.this.progress;
                    case 1 -> ObsidianForgerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ObsidianForgerBlockEntity.this.progress = value;
                    case 1 -> ObsidianForgerBlockEntity.this.maxProgress = value;
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

    /**
     * Return the IItemHandler for the given side.
     * On server this uses the BlockCapabilityCache; on client the cache isn't available so fall back to the local handler.
     */
    @Nullable
    public IItemHandler getItemHandler(@Nullable Direction side) {
        if (handlerCache != null) {
            IItemHandler cap = handlerCache.getCapability();
            if (cap != null) return cap;
        }
        // Fallback for client-side: return local itemHandler so menus can create slots and render items
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
        if (handlerCache != null) {
            handlerCache.getCapability(); // invalidate internally
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        if (customPersistentData != null) {
            tag.put("NeoForgeData", customPersistentData.copy());
        }
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("obsidian_forger.progress", progress);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, net.minecraft.core.HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("NeoForgeData", 10)) {
            customPersistentData = tag.getCompound("NeoForgeData");
        }

        // Correctly deserialize the inventory compound we saved above
        if (tag.contains("inventory", 10)) {
            CompoundTag invTag = tag.getCompound("inventory");
            itemHandler.deserializeNBT(registries, invTag);
        }

        progress = tag.getInt("obsidian_forger.progress");
    }

    public Component getDisplayName() {
        return Component.translatable("block.twindlingtweaks.obsidian_forger");
    }

    public void openMenu(ServerPlayer player) {
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return ObsidianForgerBlockEntity.this.getDisplayName();
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inv, Player pl) {
                // ✔ Matches new FiltererMenu server-side constructor
                return new ObsidianForgerMenu(id, inv, ObsidianForgerBlockEntity.this);
            }
        }, buf -> buf.writeBlockPos(this.getBlockPos()));
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

    public static void tick(Level level, BlockPos pos, BlockState state, ObsidianForgerBlockEntity be) {
        if (level.isClientSide()) {
            return;
        }

        if (ObsidianForgerBlockEntity.hasRecipe(be)) {
            be.progress++;

            if (be.progress >= be.maxProgress) {
                ObsidianForgerBlockEntity.craftItem(be);
                be.resetProgress();
            }

            ObsidianForgerBlockEntity.setChanged(level, pos, state);
        } else {
            be.resetProgress();
        }
    }

    private static boolean hasRecipe(ObsidianForgerBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(
                entity.itemHandler.getStackInSlot(0),
                entity.itemHandler.getStackInSlot(1),
                entity.itemHandler.getStackInSlot(2)
        );
        ObsidianForgerRecipeInput input = new ObsidianForgerRecipeInput(inv);

        assert level != null;
        Optional<ObsidianForgerRecipe> match = level.getRecipeManager()
                .getRecipeFor(ObsidianForgerRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(entity.itemHandler)
                && canInsertItemIntoOutputSlot(entity.itemHandler,
                match.get().getResultItem(level.registryAccess()));
    }

    private static void craftItem(ObsidianForgerBlockEntity entity) {
        Level level = entity.level;
        assert level instanceof ServerLevel serverLevel;

        SimpleContainer inv = new SimpleContainer(
                entity.itemHandler.getStackInSlot(0),
                entity.itemHandler.getStackInSlot(1),
                entity.itemHandler.getStackInSlot(2)
        );

        ObsidianForgerRecipeInput input = new ObsidianForgerRecipeInput(inv);

        Optional<ObsidianForgerRecipe> match = level.getRecipeManager()
                .getRecipeFor(ObsidianForgerRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        if (match.isEmpty()) return;

        ItemStack hammer = entity.itemHandler.getStackInSlot(0);
        if (!hammer.isDamageableItem()) return;

        hammer.hurtAndBreak(
                80,
                (ServerLevel) level,
                null,
                item -> {}
        );

        entity.itemHandler.extractItem(1, 1, false);
        entity.itemHandler.extractItem(2, 1, false);

        entity.itemHandler.setStackInSlot(
                3,
                new ItemStack(
                        match.get().getResultItem(level.registryAccess()).getItem(),
                        entity.itemHandler.getStackInSlot(3).getCount() + 1
                )
        );


        entity.resetProgress();
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(ItemStackHandler handler, ItemStack output) {
        return handler.getStackInSlot(3).isEmpty()
                || handler.getStackInSlot(3).getItem() == output.getItem();
    }

    private static boolean canInsertAmountIntoOutputSlot(ItemStackHandler handler) {
        return handler.getStackInSlot(3).getCount() < handler.getStackInSlot(3).getMaxStackSize();
    }
}