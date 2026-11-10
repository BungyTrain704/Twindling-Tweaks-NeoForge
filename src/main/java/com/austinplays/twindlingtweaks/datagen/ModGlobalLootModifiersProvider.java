package com.austinplays.twindlingtweaks.datagen;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.item.ModItems;
import com.austinplays.twindlingtweaks.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(CompletableFuture<HolderLookup.Provider> lookupProvider, PackOutput output) {
        super(output, lookupProvider,  TwindlingTweaks.MOD_ID);
    }

    @Override
    protected void start() {
        add("cucumber_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.18f).build()}, ModItems.CUCUMBER_SEEDS.get()));

        add("tomato_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.18f).build()}, ModItems.TOMATO_SEEDS.get()));

        add("lettuce_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.18f).build()}, ModItems.LETTUCE_SEEDS.get()));

        add("broccoli_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.18f).build()}, ModItems.BROCCOLI_SEEDS.get()));

        add("corn_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.18f).build()}, ModItems.CORN_SEEDS.get()));

        add("orange_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.08f).build()}, ModItems.ORANGE_SEEDS.get()));

    }
}