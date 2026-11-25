package com.austinplays.twindlingtweaks.recipes.be_recipes;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.recipes.ModRecipes;
import com.austinplays.twindlingtweaks.recipes.be_recipes.input.ObsidianForgerRecipeInput;
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

    public boolean matches(ObsidianForgerRecipeInput input, Level level) {
        if (level.isClientSide()) return false;
        if (ingredients.size() < 3) return false;

        ItemStack hammer = input.getItem(0);
        ItemStack slot1  = input.getItem(1);
        ItemStack slot2  = input.getItem(2);

        // Slot safety
        if (hammer.isEmpty() || slot1.isEmpty() || slot2.isEmpty()) {
            return false;
        }

        // Hammer must match slot 0
        if (!ingredients.get(0).test(hammer)) {
            return false;
        }

        Ingredient ingA = ingredients.get(1);
        Ingredient ingB = ingredients.get(2);

        // Order-independent matching for slots 1 & 2
        return (ingA.test(slot1) && ingB.test(slot2))
                || (ingA.test(slot2) && ingB.test(slot1));
    }

    @Override
    public ItemStack assemble(ObsidianForgerRecipeInput input, HolderLookup.Provider provider) {
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
    public RecipeSerializer<? extends Recipe<ObsidianForgerRecipeInput>> getSerializer() {
        return ModRecipes.FORGING_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ObsidianForgerRecipeInput>> getType() {
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

    public ObsidianForgerRecipe swapped() {
        // We expect: 0 = hammer, 1 & 2 = interchangeable inputs
        if (ingredients.size() < 3) {
            return this;
        }

        List<Ingredient> swappedIngredients = new ArrayList<>(ingredients.size());

        // Hammer stays in slot 0
        swappedIngredients.add(ingredients.get(0));

        // Swap slots 1 and 2
        swappedIngredients.add(ingredients.get(2));
        swappedIngredients.add(ingredients.get(1));

        // Preserve any extra ingredients (future-proofing)
        for (int i = 3; i < ingredients.size(); i++) {
            swappedIngredients.add(ingredients.get(i));
        }

        // Give the swapped recipe a unique ID (important for JEI)
        ResourceLocation swappedId = ResourceLocation.fromNamespaceAndPath(
                id.getNamespace(),
                id.getPath() + "_swapped"
        );

        return new ObsidianForgerRecipe(
                swappedId,
                swappedIngredients,
                output
        );
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