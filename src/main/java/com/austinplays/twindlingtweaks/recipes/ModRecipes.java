package com.austinplays.twindlingtweaks.recipes;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.be_recipes.CrusherRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.FiltererRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.ObsidianForgerRecipe;
import com.austinplays.twindlingtweaks.recipes.be_recipes.PasteurizerRecipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.neoforged.bus.api.IEventBus;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, TwindlingTweaks.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ObsidianForgerRecipe>> FORGING_SERIALIZER =
            SERIALIZERS.register("forging", ObsidianForgerRecipe.Serializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FiltererRecipe>> FILTERING_SERIALIZER =
            SERIALIZERS.register("filterer", FiltererRecipe.Serializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrusherRecipe>> CRUSHING_SERIALIZER =
            SERIALIZERS.register("crushing", CrusherRecipe.Serializer::new);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<PasteurizerRecipe>> PASTEURIZING_SERIALIZER =
            SERIALIZERS.register("pasteurizing", PasteurizerRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}