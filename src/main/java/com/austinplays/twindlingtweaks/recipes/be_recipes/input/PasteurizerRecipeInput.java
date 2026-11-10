package com.austinplays.twindlingtweaks.recipes.be_recipes.input;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class PasteurizerRecipeInput extends SimpleContainer implements RecipeInput {
    public PasteurizerRecipeInput(ItemStack items) {
        super(items);
    }

    public PasteurizerRecipeInput(Container container) {
        super(container.getContainerSize());
        for (int i = 0; i < container.getContainerSize(); i++) {
            setItem(i, container.getItem(i));
        }
    }

    @Override
    public int size() {
        return 1;
    }
}