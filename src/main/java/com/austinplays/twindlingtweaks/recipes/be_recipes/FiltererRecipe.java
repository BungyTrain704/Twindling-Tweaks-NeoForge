package com.austinplays.twindlingtweaks.recipes.be_recipes;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.ModRecipes;
import com.austinplays.twindlingtweaks.recipes.be_recipes.input.FiltererRecipeInput;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class FiltererRecipe implements Recipe<FiltererRecipeInput> {

    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;

    public FiltererRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack output) {
        this.id = id;

        this.ingredients = NonNullList.create();
        this.ingredients.addAll(ingredients);

        this.output = output;
    }

    @Override
    public boolean matches(FiltererRecipeInput input, Level level) {
        if (level.isClientSide()) return false;
        return !ingredients.isEmpty() && ingredients.get(0).test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(FiltererRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public RecipeSerializer<? extends Recipe<FiltererRecipeInput>> getSerializer() {
        return ModRecipes.FILTERING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<FiltererRecipeInput>> getType() {
        return TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(ingredients);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static final RecipeType<FiltererRecipe> TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "filtering").toString();
        }
    };

    public static class Serializer implements RecipeSerializer<FiltererRecipe> {

        public static final Serializer INSTANCE = new Serializer();

        private static final StreamCodec<RegistryFriendlyByteBuf, FiltererRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, FiltererRecipe::getId,
                        new StreamCodec<RegistryFriendlyByteBuf, List<Ingredient>>() {
                            @Override
                            public List<Ingredient> decode(RegistryFriendlyByteBuf buf) {
                                int size = buf.readVarInt();
                                List<Ingredient> list = new ArrayList<>();
                                for (int i = 0; i < size; i++) {
                                    list.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
                                }
                                return list;
                            }

                            @Override
                            public void encode(RegistryFriendlyByteBuf buf, List<Ingredient> value) {
                                buf.writeVarInt(value.size());
                                for (Ingredient ingredient : value) {
                                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
                                }
                            }
                        }, FiltererRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, FiltererRecipe::getOutput,
                        (id, ingredients, output) -> new FiltererRecipe(id, ingredients, output)
                );

        @Override
        public MapCodec<FiltererRecipe> codec() {
            return RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("id").forGetter(FiltererRecipe::getId),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(FiltererRecipe::getIngredients),
                    ItemStack.CODEC.fieldOf("output").forGetter(FiltererRecipe::getOutput)
            ).apply(instance, (id, ingredientsList, output) -> new FiltererRecipe(id, ingredientsList, output)));
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FiltererRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}