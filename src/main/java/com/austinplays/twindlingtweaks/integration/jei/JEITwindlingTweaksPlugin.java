package com.austinplays.twindlingtweaks.integration.jei;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.integration.jei.categories.block_entity.CrusherRecipeCategory;
import com.austinplays.twindlingtweaks.integration.jei.categories.block_entity.FiltererRecipeCategory;
import com.austinplays.twindlingtweaks.integration.jei.categories.block_entity.ObsidianForgerRecipeCategory;
import com.austinplays.twindlingtweaks.integration.jei.categories.block_entity.special_block_entity.PasteurizerRecipeCategory;
import com.austinplays.twindlingtweaks.integration.jei.recipes.ModJEIRecipes;
import com.austinplays.twindlingtweaks.recipes.be_recipes.CrusherRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.ObsidianForgerRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEITwindlingTweaksPlugin implements IModPlugin {

    public static RecipeType<ObsidianForgerRecipe> FORGING_TYPE =
            new RecipeType<>(ObsidianForgerRecipeCategory.UID, ObsidianForgerRecipe.class);

    public static RecipeType<CrusherRecipe> CRUSHING_TYPE =
            new RecipeType<>(CrusherRecipeCategory.UID, CrusherRecipe.class);

    public static RecipeType<FiltererRecipe> FILTERING_TYPE =
            new RecipeType<>(FiltererRecipeCategory.UID, FiltererRecipe.class);

    public static final RecipeType<PasteurizerRecipe> PASTEURIZING_TYPE =
            RecipeType.create(TwindlingTweaks.MOD_ID, "pasteurizing", PasteurizerRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        var guiHelper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new ObsidianForgerRecipeCategory(guiHelper));
        registration.addRecipeCategories(new FiltererRecipeCategory(guiHelper));
        registration.addRecipeCategories(new CrusherRecipeCategory(guiHelper));
        registration.addRecipeCategories(new PasteurizerRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<RecipeHolder<ObsidianForgerRecipe>> forgingHolders =
                rm.getAllRecipesFor(ObsidianForgerRecipe.TYPE);

        List<ObsidianForgerRecipe> expandedForgingRecipes = new ArrayList<>();

        for (RecipeHolder<ObsidianForgerRecipe> holder : forgingHolders) {
            ObsidianForgerRecipe recipe = holder.value();
            expandedForgingRecipes.add(recipe);

            // Ingredients: 0 = hammer, 1 & 2 = interchangeable
            if (recipe.getIngredients().size() >= 3) {
                Ingredient a = recipe.getIngredients().get(1);
                Ingredient b = recipe.getIngredients().get(2);

                // Avoid duplicate JEI entries if both ingredients are identical
                if (!a.equals(b)) {
                    expandedForgingRecipes.add(recipe.swapped());
                }
            }
        }

        registration.addRecipes(FORGING_TYPE, expandedForgingRecipes);

        List<FiltererRecipe> recipesFiltering =
                rm.getAllRecipesFor(FiltererRecipe.TYPE)
                        .stream()
                        .map(RecipeHolder::value)
                        .toList();

        registration.addRecipes(FILTERING_TYPE, recipesFiltering);

        List<CrusherRecipe> recipesCrushing =
                rm.getAllRecipesFor(CrusherRecipe.TYPE)
                        .stream()
                        .map(RecipeHolder::value)
                        .toList();

        registration.addRecipes(CRUSHING_TYPE, recipesCrushing);

        List<PasteurizerRecipe> recipesPasteurizing =
                rm.getAllRecipesFor(PasteurizerRecipe.TYPE)
                        .stream()
                        .map(RecipeHolder::value)
                        .toList();

        registration.addRecipes(PASTEURIZING_TYPE, recipesPasteurizing);

        // Dummy JEI-only recipe
        registration.addRecipes(
                PASTEURIZING_TYPE,
                ModJEIRecipes.getDummyRecipes()
        );
    }
}