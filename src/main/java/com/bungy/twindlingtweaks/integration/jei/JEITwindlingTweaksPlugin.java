package com.bungy.twindlingtweaks.integration.jei;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.integration.jei.categories.block_entity.CrusherRecipeCategory;
import com.bungy.twindlingtweaks.integration.jei.categories.block_entity.FiltererRecipeCategory;
import com.bungy.twindlingtweaks.integration.jei.categories.block_entity.ObsidianForgerRecipeCategory;
import com.bungy.twindlingtweaks.integration.jei.categories.block_entity.special_block_entity.PasteurizerRecipeCategory;
import com.bungy.twindlingtweaks.integration.jei.recipes.ModJEIRecipes;
import com.bungy.twindlingtweaks.recipes.be_recipes.CrusherRecipe;
import com.bungy.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import com.bungy.twindlingtweaks.recipes.be_recipes.ObsidianForgerRecipe;
import com.bungy.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

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
        registration.addRecipeCategories(new
                ObsidianForgerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                FiltererRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                CrusherRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                PasteurizerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<RecipeHolder<ObsidianForgerRecipe>> forgingHolders = rm.getAllRecipesFor(ObsidianForgerRecipe.TYPE);
        List<ObsidianForgerRecipe> recipesForging = forgingHolders.stream().map(RecipeHolder::value).toList();
        registration.addRecipes(FORGING_TYPE, recipesForging);

        List<RecipeHolder<FiltererRecipe>> filteringHolders = rm.getAllRecipesFor(FiltererRecipe.TYPE);
        List<FiltererRecipe> recipesFiltering = filteringHolders.stream().map(RecipeHolder::value).toList();
        registration.addRecipes(FILTERING_TYPE, recipesFiltering);

        List<RecipeHolder<CrusherRecipe>> crushingHolders = rm.getAllRecipesFor(CrusherRecipe.TYPE);
        List<CrusherRecipe> recipesCrushing = crushingHolders.stream().map(RecipeHolder::value).toList();
        registration.addRecipes(CRUSHING_TYPE, recipesCrushing);

        List<RecipeHolder<PasteurizerRecipe>> pasteurizingHolders = rm.getAllRecipesFor(PasteurizerRecipe.TYPE);
        List<PasteurizerRecipe> recipesPasteurizing = pasteurizingHolders.stream().map(RecipeHolder::value).toList();
        registration.addRecipes(PASTEURIZING_TYPE, recipesPasteurizing);

        registration.addRecipes(
                JEITwindlingTweaksPlugin.PASTEURIZING_TYPE,
                ModJEIRecipes.getDummyRecipes()
        );
    }
}