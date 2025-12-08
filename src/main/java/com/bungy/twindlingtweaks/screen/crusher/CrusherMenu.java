package com.bungy.twindlingtweaks.screen.crusher;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.entity.custom.block_entity.CrusherBlockEntity;
import com.bungy.twindlingtweaks.screen.ModMenuTypes;
import com.bungy.twindlingtweaks.screen.slot.ModResultSlot;
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


public class CrusherMenu extends AbstractContainerMenu {
    public final CrusherBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    // Server-side constructor
    public CrusherMenu(int id, Inventory inv, CrusherBlockEntity entity) {
        super(ModMenuTypes.CRUSHER_MENU.get(), id);
        this.blockEntity = entity;
        this.level = inv.player.level();
        this.data = entity.getData();
        setupSlots(inv);
    }

    // Client-side constructor (called when receiving the screen packet)
    public CrusherMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        super(ModMenuTypes.CRUSHER_MENU.get(), id);
        BlockPos pos = buf.readBlockPos(); // read block position from buffer
        this.blockEntity = (CrusherBlockEntity) Objects.requireNonNull(inv.player.level().getBlockEntity(pos));
        this.level = inv.player.level();
        this.data = blockEntity.getData();
        setupSlots(inv);
    }

    private void setupSlots(Inventory playerInventory) {
        checkContainerSize(playerInventory, 3);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        IItemHandler handler = blockEntity.getItemHandler(null);
        if (handler != null) {
            this.addSlot(new SlotItemHandler(handler, 0, 35, 8));
            this.addSlot(new SlotItemHandler(handler, 1, 35, 35));
            this.addSlot(new ModResultSlot(handler, 2, 115, 34));
        }

        addDataSlots(data);
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.CRUSHER.get());
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int progressArrowSize = 48;

        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMoveStack(Player playerIn, int index) {
        // Keep your existing quickMoveStack logic
        Slot sourceSlot = slots.get(index);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        final int VANILLA_SLOT_COUNT = 36;
        final int TE_INVENTORY_SLOT_COUNT = 3;
        final int VANILLA_FIRST_SLOT_INDEX = 0;
        final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

        if (index < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX,
                    TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else if (index < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX,
                    VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + index);
            return ItemStack.EMPTY;
        }

        if (sourceStack.getCount() == 0) sourceSlot.set(ItemStack.EMPTY);
        else sourceSlot.setChanged();
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }
}