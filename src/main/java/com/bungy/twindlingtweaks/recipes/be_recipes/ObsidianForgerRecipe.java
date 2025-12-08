package com.bungy.twindlingtweaks.recipes.be_recipes;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.recipes.be_recipes.input.ObsidianForgerRecipeInput;
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

public class ObsidianForgerRecipe implements Recipe<ObsidianForgerRecipeInput> {

    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;

    public ObsidianForgerRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack output) {
        this.id = id;

        this.ingredients = NonNullList.create();
        this.ingredients.addAll(ingredients);

        this.output = output;
    }

    @Override
    public boolean matches(ObsidianForgerRecipeInput input, Level level) {
        if (level.isClientSide()) return false;
        if (ingredients.size() < 3) return false;

        return ingredients.get(0).test(input.getItem(0))
                && ingredients.get(1).test(input.getItem(1))
                && ingredients.get(2).test(input.getItem(2));
    }

    @Override
    public ItemStack assemble(ObsidianForgerRecipeInput input, HolderLookup.Provider provider) {
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
        return ModRecipes.FORGING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }

    public static final RecipeType<ObsidianForgerRecipe> TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "forging").toString();
        }
    };

    public static class Serializer implements RecipeSerializer<ObsidianForgerRecipe> {

        public static final Serializer INSTANCE = new Serializer();

        private static final StreamCodec<RegistryFriendlyByteBuf, ObsidianForgerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, ObsidianForgerRecipe::getId,
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
                        }, ObsidianForgerRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, ObsidianForgerRecipe::getOutput,
                        (id, ingredients, output) -> new ObsidianForgerRecipe(id, ingredients, output)
                );

        @Override
        public MapCodec<ObsidianForgerRecipe> codec() {
            return RecordCodecBuilder.mapCodec(instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("id").forGetter(ObsidianForgerRecipe::getId),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(ObsidianForgerRecipe::getIngredients),
                    ItemStack.CODEC.fieldOf("output").forGetter(ObsidianForgerRecipe::getOutput)
            ).apply(instance, (id, ingredientsList, output) -> new ObsidianForgerRecipe(id, ingredientsList, output)));
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ObsidianForgerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}