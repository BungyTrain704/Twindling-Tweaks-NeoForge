package com.bungy.twindlingtweaks.datagen.builder;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class FiltererRecipeBuilder {
    private final Ingredient input;
    private final Item output;
    private int amount = 1; // default

    private FiltererRecipeBuilder(Ingredient input, Item output) {
        this.input = input;
        this.output = output;
    }

    public static FiltererRecipeBuilder of(Ingredient input, Item output) {
        return new FiltererRecipeBuilder(input, output);
    }

    public static FiltererRecipeBuilder of(Item input, Item output) {
        return new FiltererRecipeBuilder(Ingredient.of(input), output);
    }

    public FiltererRecipeBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public void save(RecipeOutput recipeOutput, String name) {
        save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
    }

    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        NonNullList<Ingredient> ingredients = NonNullList.of(Ingredient.EMPTY, this.input);
        FiltererRecipe recipe = new FiltererRecipe(id, ingredients, new ItemStack(this.output, this.amount));
        recipeOutput.accept(id, recipe, null);
    }
}