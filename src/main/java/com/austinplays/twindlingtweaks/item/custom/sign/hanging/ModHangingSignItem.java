package com.austinplays.twindlingtweaks.item.custom.sign.hanging;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

public class ModHangingSignItem extends HangingSignItem {
    private int burnTime = 0;
    public ModHangingSignItem(Block pBlock, Block pWallBlock, Properties pProperties, int burnTime) {
        super(pBlock, pWallBlock, pProperties);
        this.burnTime = burnTime;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues values) {
        return this.burnTime;
    }
}