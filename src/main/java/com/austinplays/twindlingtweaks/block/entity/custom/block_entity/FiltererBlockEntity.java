package com.austinplays.twindlingtweaks.block.entity.custom.block_entity;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.input.FiltererRecipeInput;
import com.austinplays.twindlingtweaks.screen.filterer.FiltererMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
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

import java.util.Optional;

public class FiltererBlockEntity extends BlockEntity {
    @Nullable
    private CompoundTag customPersistentData;

    private final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private BlockCapabilityCache<IItemHandler, @Nullable Direction> handlerCache;

    private final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public FiltererBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FILTERER_BLOCK_ENTITY.get(), pos, state);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FiltererBlockEntity.this.progress;
                    case 1 -> FiltererBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FiltererBlockEntity.this.progress = value;
                    case 1 -> FiltererBlockEntity.this.maxProgress = value;
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
        if (level instanceof ServerLevel serverLevel) {
            handlerCache = BlockCapabilityCache.create(
                    Capabilities.ItemHandler.BLOCK,
                    serverLevel,
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
        tag.putInt("filterer.progress", progress);
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
        progress = tag.getInt("filterer.progress");
    }

    public Component getDisplayName() {
        return Component.translatable("block.twindlingtweaks.filterer");
    }

    public void openMenu(ServerPlayer player) {
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return FiltererBlockEntity.this.getDisplayName();
            }

            @Override
            public AbstractContainerMenu createMenu(int id, Inventory inv, Player pl) {
                return new FiltererMenu(id, inv, FiltererBlockEntity.this);
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

    public static void tick(Level level, BlockPos pos, BlockState state, FiltererBlockEntity be) {
        if (level.isClientSide()) {
            return;
        }

        if (FiltererBlockEntity.hasRecipe(be)) {
            be.progress++;

            if (be.progress >= be.maxProgress) {
                FiltererBlockEntity.craftItem(be);
                be.resetProgress();
            }

            FiltererBlockEntity.setChanged(level, pos, state);
        } else {
            be.resetProgress();
        }
    }

    private static boolean hasRecipe(FiltererBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(
                entity.itemHandler.getStackInSlot(0)
        );
        FiltererRecipeInput input = new FiltererRecipeInput(inv);

        assert level != null;
        java.util.Optional<FiltererRecipe> match = ((ServerLevel) level).recipeAccess()
                .getRecipeFor(FiltererRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        return match.isPresent()
                && canInsertAmountIntoOutputSlot(entity.itemHandler)
                && canInsertItemIntoOutputSlot(
                entity.itemHandler,
                match.get().getOutput()
        );
    }

    private static void craftItem(FiltererBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inv = new SimpleContainer(entity.itemHandler.getStackInSlot(0));
        FiltererRecipeInput input = new FiltererRecipeInput(inv);

        Optional<FiltererRecipe> match = ((ServerLevel) level).recipeAccess()
                .getRecipeFor(FiltererRecipe.TYPE, input, level)
                .map(RecipeHolder::value);

        if (match.isPresent()) {
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.setStackInSlot(
                    1,
                    new ItemStack(
                            match.get().getOutput().getItem(),
                            entity.itemHandler.getStackInSlot(1).getCount() + 1
                    )
            );
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(ItemStackHandler handler, ItemStack output) {
        return handler.getStackInSlot(1).isEmpty()
                || handler.getStackInSlot(1).getItem() == output.getItem();
    }

    private static boolean canInsertAmountIntoOutputSlot(ItemStackHandler handler) {
        return handler.getStackInSlot(1).getCount()
                < handler.getStackInSlot(1).getMaxStackSize();
    }
}