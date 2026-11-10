package com.austinplays.twindlingtweaks.integration.jei.recipes;

import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class ModJEIRecipes {
    public static List<PasteurizerRecipe> getDummyRecipes() {
        List<PasteurizerRecipe> recipes = new ArrayList<>();

        recipes.add(new PasteurizerRecipe(
                ResourceLocation.fromNamespaceAndPath("twindlingtweaks", "dummy_goat_milk"),
                NonNullList.of(Ingredient.EMPTY, Ingredient.of(ModItems.GOAT_MILK.get())),
                new ItemStack(ModItems.GOAT_MILK.get())
        ));

        return recipes;
    }
}