package com.austinplays.twindlingtweaks.datagen.builder;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.be_recipes.ObsidianForgerRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class ObsidianForgerRecipeBuilder {

    private final Ingredient tagInput;
    private final Ingredient itemInput1;
    private final Ingredient itemInput2;
    private final Item output;

    private int amount = 1;

    private ObsidianForgerRecipeBuilder(
            Ingredient tagInput,
            Ingredient itemInput1,
            Ingredient itemInput2,
            Item output
    ) {
        this.tagInput = tagInput;
        this.itemInput1 = itemInput1;
        this.itemInput2 = itemInput2;
        this.output = output;
    }

    public static ObsidianForgerRecipeBuilder of(
            Ingredient tagInput,
            Item item1,
            Item item2,
            Item output
    ) {
        return new ObsidianForgerRecipeBuilder(
                tagInput,
                Ingredient.of(item1),
                Ingredient.of(item2),
                output
        );
    }

    public static ObsidianForgerRecipeBuilder of(
            Ingredient tagInput,
            Item item1,
            Item item2,
            ItemStack result
    ) {
        return new ObsidianForgerRecipeBuilder(
                tagInput,
                Ingredient.of(item1),
                Ingredient.of(item2),
                result.getItem()
        ).setAmount(result.getCount());
    }

    public ObsidianForgerRecipeBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public void save(
            RecipeOutput recipeOutput,
            String name
    ) {
        save(
                recipeOutput,
                ResourceLocation.fromNamespaceAndPath(
                        TwindlingTweaks.MOD_ID,
                        name
                )
        );
    }

    public void save(
            RecipeOutput output,
            ResourceLocation id
    ) {
        NonNullList<Ingredient> ingredients =
                NonNullList.create();

        ingredients.add(tagInput);
        ingredients.add(itemInput1);
        ingredients.add(itemInput2);

        ObsidianForgerRecipe recipe =
                new ObsidianForgerRecipe(
                        id,
                        ingredients,
                        new ItemStack(this.output, this.amount)
                );

        output.accept(
                ResourceKey.create(
                        Registries.RECIPE,
                        id
                ),
                recipe,
                null
        );
    }
}