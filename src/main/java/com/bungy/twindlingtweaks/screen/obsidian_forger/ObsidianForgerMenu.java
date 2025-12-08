package com.bungy.twindlingtweaks.screen.obsidian_forger;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.entity.custom.block_entity.ObsidianForgerBlockEntity;
import com.bungy.twindlingtweaks.screen.ModMenuTypes;
import com.bungy.twindlingtweaks.screen.slot.ModResultSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

import java.util.Objects;


public class ObsidianForgerMenu extends AbstractContainerMenu {
    public final ObsidianForgerBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    // -------------------------------------------------------------
    // 1) Server-side constructor
    // -------------------------------------------------------------
    public ObsidianForgerMenu(int id, Inventory inv, ObsidianForgerBlockEntity entity) {
        super(ModMenuTypes.OBSIDIAN_FORGER_MENU.get(), id);
        this.blockEntity = entity;
        this.level = inv.player.level();
        this.data = entity.getData();
        setupSlots(inv);
    }

    // -------------------------------------------------------------
    // 2) Client-side constructor (reads BlockPos from buffer)
    // -------------------------------------------------------------
    public ObsidianForgerMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, (ObsidianForgerBlockEntity) Objects.requireNonNull(
                inv.player.level().getBlockEntity(buf.readBlockPos())
        ));
    }

    // -------------------------------------------------------------
    // Setup all slots (player + block)
    // -------------------------------------------------------------
    private void setupSlots(Inventory playerInventory) {
        // Validate size (server-side only)
        checkContainerSize(playerInventory, 4);

        // Player inventory
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        // Block inventory
        IItemHandler handler = blockEntity.getItemHandler(null);
        if (handler != null) {
            this.addSlot(new SlotItemHandler(handler, 0, 18, 50));
            this.addSlot(new SlotItemHandler(handler, 1, 66, 16));
            this.addSlot(new SlotItemHandler(handler, 2, 66, 50));
            this.addSlot(new ModResultSlot(handler, 3, 114, 33));
        }

        // Sync progress + max_progress
        addDataSlots(data);
    }

    // -------------------------------------------------------------
    // Crafting state
    // -------------------------------------------------------------
    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowSize = 36;
        return maxProgress != 0 && progress != 0 ? progress * arrowSize / maxProgress : 0;
    }

    // -------------------------------------------------------------
    // Quick move logic
    // -------------------------------------------------------------
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INV_ROW_COUNT = 3;
    private static final int PLAYER_INV_COL_COUNT = 9;
    private static final int PLAYER_INV_SLOT_COUNT = PLAYER_INV_ROW_COUNT * PLAYER_INV_COL_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INV_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;
    private static final int TE_INVENTORY_SLOT_COUNT = 4;

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

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

        if (sourceStack.isEmpty()) sourceSlot.set(ItemStack.EMPTY);
        else sourceSlot.setChanged();
        sourceSlot.onTake(player, sourceStack);
        return copyOfSourceStack;
    }

    // -------------------------------------------------------------
    // Valid menu check
    // -------------------------------------------------------------
    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.OBSIDIAN_FORGER.get());
    }

    // -------------------------------------------------------------
    // Player inventory slots
    // -------------------------------------------------------------
    private void addPlayerInventory(Inventory playerInventory) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(playerInventory,
                        col + row * 9 + 9,
                        8 + col * 18,
                        86 + row * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 144));
        }
    }
}