package com.austinplays.twindlingtweaks.screen.filterer;

import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.FiltererBlockEntity;
import com.austinplays.twindlingtweaks.screen.ModMenuTypes;
import com.austinplays.twindlingtweaks.screen.slot.ModResultSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

import java.util.Objects;


public class FiltererMenu extends AbstractContainerMenu {
    public final FiltererBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    // ---- SERVER-SIDE CONSTRUCTOR ----
    public FiltererMenu(int id, Inventory inv, FiltererBlockEntity entity) {
        super(ModMenuTypes.FILTERER_MENU.get(), id);
        this.blockEntity = entity;
        this.level = inv.player.level();
        this.data = entity.getData();
        setupSlots(inv);
    }

    // ---- CLIENT-SIDE CONSTRUCTOR ----
    public FiltererMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        super(ModMenuTypes.FILTERER_MENU.get(), id);
        BlockPos pos = buf.readBlockPos();

        this.blockEntity = (FiltererBlockEntity)
                Objects.requireNonNull(inv.player.level().getBlockEntity(pos));

        this.level = inv.player.level();
        this.data = blockEntity.getData();
        setupSlots(inv);
    }

    // ---- SETUP SLOTS ----
    private void setupSlots(Inventory playerInventory) {
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        IItemHandler handler = blockEntity.getItemHandler(null);
        if (handler != null) {
            this.addSlot(new SlotItemHandler(handler, 0, 80, 11)); // Input
            this.addSlot(new ModResultSlot(handler, 1, 80, 59));   // Output
        }

        addDataSlots(data);
    }

    // ---- CRAFTING STATE ----
    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 26;

        return maxProgress != 0 && progress != 0
                ? progress * progressArrowSize / maxProgress
                : 0;
    }

    // ---- QUICK MOVE ----
    private static final int VANILLA_SLOT_COUNT = 36;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 2;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyStack = sourceStack.copy();

        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack,
                    TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT,
                    false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack,
                    VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT,
                    false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slot index: " + index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) sourceSlot.set(ItemStack.EMPTY);
        else sourceSlot.setChanged();

        sourceSlot.onTake(player, sourceStack);
        return copyStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.FILTERER.get());
    }

    // ---- PLAYER INVENTORY SLOTS ----
    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        84 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory,
                    i,
                    8 + i * 18,
                    142));
        }
    }
}