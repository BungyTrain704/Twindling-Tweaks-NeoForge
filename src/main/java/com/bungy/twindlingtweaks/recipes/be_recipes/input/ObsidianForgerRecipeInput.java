package com.bungy.twindlingtweaks.recipes.be_recipes.input;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class ObsidianForgerRecipeInput extends SimpleContainer implements RecipeInput {
    public ObsidianForgerRecipeInput(ItemStack items) {
        super(items);
    }

    public ObsidianForgerRecipeInput(Container container) {
        super(container.getContainerSize());
        for (int i = 0; i < container.getContainerSize(); i++) {
            setItem(i, container.getItem(i));
        }
    }

    @Override
    public int size() {
        return 3;
    }
}