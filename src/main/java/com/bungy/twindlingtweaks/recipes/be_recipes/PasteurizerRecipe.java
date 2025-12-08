package com.bungy.twindlingtweaks.recipes.be_recipes;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.recipes.be_recipes.input.PasteurizerRecipeInput;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public class PasteurizerRecipe implements Recipe<PasteurizerRecipeInput> {

    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;

    public PasteurizerRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack output) {
        this.id = id;
        this.ingredients = NonNullList.create();
        this.ingredients.addAll(ingredients);
        this.output = output;
    }

    @Override
    public boolean matches(PasteurizerRecipeInput input, Level level) {
        if (level.isClientSide()) return false;
        return !ingredients.isEmpty() && ingredients.get(0).test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(PasteurizerRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.PASTEURIZING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }

    public static final RecipeType<PasteurizerRecipe> TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "pasteurizing").toString();
        }
    };

    public static class Serializer implements RecipeSerializer<PasteurizerRecipe> {

        public static final Serializer INSTANCE = new Serializer();

        private static final StreamCodec<RegistryFriendlyByteBuf, PasteurizerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, PasteurizerRecipe::getId,
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
                        }, PasteurizerRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, PasteurizerRecipe::getOutput,
                        (id, ingredients, output) -> new PasteurizerRecipe(id, ingredients, output)
                );

        @Override
        public MapCodec<PasteurizerRecipe> codec() {
            return RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("id").forGetter(PasteurizerRecipe::getId),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(PasteurizerRecipe::getIngredients),
                    ItemStack.CODEC.fieldOf("output").forGetter(PasteurizerRecipe::getOutput)
            ).apply(instance, (id, ingredientsList, output) -> new PasteurizerRecipe(id, ingredientsList, output)));
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, PasteurizerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}