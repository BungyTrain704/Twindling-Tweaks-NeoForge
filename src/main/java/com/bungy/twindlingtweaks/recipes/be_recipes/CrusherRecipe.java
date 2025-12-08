package com.bungy.twindlingtweaks.recipes.be_recipes;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.recipes.ModRecipes;
import com.bungy.twindlingtweaks.recipes.be_recipes.input.CrusherRecipeInput;
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

public class CrusherRecipe implements Recipe<CrusherRecipeInput> {

    private final ResourceLocation id;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;

    public CrusherRecipe(ResourceLocation id, List<Ingredient> ingredients, ItemStack output) {
        this.id = id;

        this.ingredients = NonNullList.create();
        this.ingredients.addAll(ingredients);

        this.output = output;
    }

    // -------------------------
    // Matching logic
    // -------------------------
    @Override
    public boolean matches(CrusherRecipeInput input, Level level) {
        if (level.isClientSide()) return false;
        if (ingredients.size() < 2) return false;

        return ingredients.get(0).test(input.getItem(0))
                && ingredients.get(1).test(input.getItem(1));
    }

    @Override
    public ItemStack assemble(CrusherRecipeInput input, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int w, int h) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return ingredients;
    }

    public ItemStack getOutput() {
        return output;
    }

    public ResourceLocation getId() {
        return id;
    }

    // -------------------------
    // Type + Serializer
    // -------------------------
    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CRUSHING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }

    public static class Serializer implements RecipeSerializer<CrusherRecipe> {

        public static final Serializer INSTANCE = new Serializer();

        public static final MapCodec<CrusherRecipe> CODEC = RecordCodecBuilder.mapCodec(inst ->
                inst.group(
                        ResourceLocation.CODEC.fieldOf("id").forGetter(CrusherRecipe::getId),
                        Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(CrusherRecipe::getIngredients),
                        ItemStack.CODEC.fieldOf("output").forGetter(CrusherRecipe::getOutput)
                ).apply(inst, CrusherRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, CrusherRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, CrusherRecipe::getId,
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
                        }, CrusherRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, CrusherRecipe::getOutput,
                        CrusherRecipe::new
                );

        @Override
        public MapCodec<CrusherRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CrusherRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

    public static final RecipeType<CrusherRecipe> TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "crushing").toString();
        }
    };
}