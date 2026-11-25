package com.austinplays.twindlingtweaks.datagen.builder;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.be_recipes.CrusherRecipe;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;


public class CrusherRecipeBuilder {

    private final Ingredient tagInput;
    private final Ingredient itemInput;
    private final Item output;

    private int amount = 1;

    private CrusherRecipeBuilder(
            Ingredient tagInput,
            Ingredient itemInput,
            Item output
    ) {
        this.tagInput = tagInput;
        this.itemInput = itemInput;
        this.output = output;
    }

    public static CrusherRecipeBuilder of(
            Ingredient tagInput,
            Item item,
            Item output
    ) {
        return new CrusherRecipeBuilder(
                tagInput,
                Ingredient.of(item),
                output
        );
    }

    public static CrusherRecipeBuilder of(
            Ingredient tagInput,
            Item item,
            ItemStack result
    ) {
        return new CrusherRecipeBuilder(
                tagInput,
                Ingredient.of(item),
                result.getItem()
        ).setAmount(result.getCount());
    }

    public CrusherRecipeBuilder setAmount(int amount) {
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
        ingredients.add(itemInput);

        CrusherRecipe recipe =
                new CrusherRecipe(
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