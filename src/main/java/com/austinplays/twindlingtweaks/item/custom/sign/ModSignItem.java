package com.austinplays.twindlingtweaks.item.custom.sign;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.Nullable;

public class ModSignItem extends SignItem {
    private int burnTime = 0;
    public ModSignItem(Properties pProperties, Block pStandingBlock, Block pWallBlock, int burnTime) {
        super(pStandingBlock, pWallBlock, pProperties);
        this.burnTime = burnTime;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues values) {
        return this.burnTime;
    }
}
