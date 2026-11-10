package com.austinplays.twindlingtweaks.datagen.builder;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class PasteurizerRecipeBuilder {
    private final Ingredient input;
    private final Item output;
    private int amount = 1; // default

    private PasteurizerRecipeBuilder(Ingredient input, Item output) {
        this.input = input;
        this.output = output;
    }

    public static PasteurizerRecipeBuilder of(Ingredient input, Item output) {
        return new PasteurizerRecipeBuilder(input, output);
    }

    public static PasteurizerRecipeBuilder of(Item input, Item output) {
        return new PasteurizerRecipeBuilder(Ingredient.of(input), output);
    }

    public PasteurizerRecipeBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public void save(RecipeOutput output) {
        save(output, "pasteurizer/" + this.output.toString().toLowerCase());
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