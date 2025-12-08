package com.bungy.twindlingtweaks.datagen;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.custom.crops.*;
import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    private static final int NORMAL_LEAVES_SAPLING_CHANCE = 20;

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CATALPA_PLANKS.get());
        this.dropSelf(ModBlocks.RED_MAPLE_PLANKS.get());

        this.add(ModBlocks.ALLUMINITE_ORE.get(),
                block -> createAlluminiteLikeOreDrops(ModBlocks.ALLUMINITE_ORE.get(), ModItems.RAW_ALLUMINITE.get()));
        this.add(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get(),
                block -> createAlluminiteLikeOreDrops(ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get(), ModItems.RAW_ALLUMINITE.get()));
        this.add(ModBlocks.LUMINIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.LUMINIUM_ORE.get(), ModItems.UNPROCESSED_LUMINIUM_CHUNK.get()));
        this.add(ModBlocks.DEEPSLATE_LUMINIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_LUMINIUM_ORE.get(), ModItems.UNPROCESSED_LUMINIUM_CHUNK.get()));
        this.add(ModBlocks.SUGAR_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SUGAR_ORE.get(), ModItems.UNFILTERED_SUGAR.get()));
        this.add(ModBlocks.DEEPSLATE_SUGAR_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SUGAR_ORE.get(), ModItems.UNFILTERED_SUGAR.get()));
        this.add(ModBlocks.MUD_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MUD_ORE.get(), ModItems.MUD_BALL.get()));
        this.add(ModBlocks.DEEPSLATE_MUD_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_MUD_ORE.get(), ModItems.MUD_BALL.get()));
        this.add(ModBlocks.SALT_ORE.get(),
                block -> createAlluminiteLikeOreDrops(ModBlocks.SALT_ORE.get(), ModItems.SALT_ROCK.get()));
        this.add(ModBlocks.DEEPSLATE_SALT_ORE.get(),
                block -> createAlluminiteLikeOreDrops(ModBlocks.DEEPSLATE_SUGAR_ORE.get(), ModItems.SALT_ROCK.get()));

        this.dropSelf(ModBlocks.CATALPA_STAIRS.get());
        this.dropSelf(ModBlocks.CATALPA_BUTTON.get());
        this.dropSelf(ModBlocks.CATALPA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CATALPA_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CATALPA_FENCE.get());
        this.dropSelf(ModBlocks.CATALPA_FENCE_GATE.get());
        this.dropSelf(ModBlocks.RED_MAPLE_STAIRS.get());
        this.dropSelf(ModBlocks.RED_MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.RED_MAPLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.RED_MAPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.RED_MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.RED_MAPLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MUD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SPEEDY_FARMLAND.get());
        this.dropSelf(ModBlocks.BLUE_DIRT.get());
        this.dropOther(ModBlocks.BLUE_DIRT_PATH.get(), ModBlocks.BLUE_DIRT.get());
        this.dropSelf(ModBlocks.FLASH_FARMLAND.get());
        this.dropSelf(ModBlocks.YELLOW_DIRT.get());
        this.dropOther(ModBlocks.YELLOW_DIRT_PATH.get(), ModBlocks.YELLOW_DIRT.get());
        this.dropSelf(ModBlocks.FIERY_FARMLAND.get());
        this.dropSelf(ModBlocks.RED_DIRT.get());
        this.dropOther(ModBlocks.RED_DIRT_PATH.get(), ModBlocks.RED_DIRT.get());
        this.dropSelf(ModBlocks.TWINDLING_TWEAKS_FARMLAND.get());
        this.dropSelf(ModBlocks.ALLUMIN_LUMINIUM_DIRT.get());
        this.dropOther(ModBlocks.ALLUMIN_LUMINIUM_DIRT_PATH.get(), ModBlocks.ALLUMIN_LUMINIUM_DIRT.get());
        this.dropOther(ModBlocks.COARSE_DIRT_PATH.get(), Blocks.COARSE_DIRT);
        this.dropOther(ModBlocks.ROOTED_DIRT_PATH.get(), Blocks.ROOTED_DIRT);
        this.dropOther(ModBlocks.SOUL_SAND_PATH.get(), Blocks.SOUL_SAND);
        this.dropOther(ModBlocks.SOUL_SOIL_PATH.get(), Blocks.SOUL_SOIL);


        this.dropSelf(ModBlocks.GOAT_CAKE.get());

        this.add(ModBlocks.CATALPA_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CATALPA_SLAB.get()));
        this.add(ModBlocks.CATALPA_DOOR.get(),
                block -> createDoorTable(ModBlocks.CATALPA_DOOR.get()));

        this.add(ModBlocks.RED_MAPLE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_MAPLE_SLAB.get()));
        this.add(ModBlocks.RED_MAPLE_DOOR.get(),
                block -> createDoorTable(ModBlocks.RED_MAPLE_DOOR.get()));

        this.add(ModBlocks.MUD_DOOR.get(),
                block -> createDoorTable(ModBlocks.MUD_DOOR.get()));


        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.BLUEBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        this.add(ModBlocks.RASPBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RASPBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.RASPBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RASPBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.RASPBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));


        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CUCUMBER_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CucumberPlantBlock.AGE, CucumberPlantBlock.MAX_AGE));

        this.add(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.CUCUMBER_SEEDS_BLOCK.get(),
                ModItems.CUCUMBER.get(), ModItems.CUCUMBER_SEEDS.get(), lootItemConditionBuilder));

        LootItemCondition.Builder lootItemConditionBuilder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.TOMATO_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoPlantBlock.AGE, TomatoPlantBlock.MAX_AGE));

        this.add(ModBlocks.TOMATO_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.TOMATO_SEEDS_BLOCK.get(),
                ModItems.TOMATO.get(), ModItems.TOMATO_SEEDS.get(), lootItemConditionBuilder2));

        LootItemCondition.Builder lootItemConditionBuilder3 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.LETTUCE_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LettucePlantBlock.AGE, LettucePlantBlock.MAX_AGE));

        this.add(ModBlocks.LETTUCE_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.LETTUCE_SEEDS_BLOCK.get(),
                ModItems.LETTUCE.get(), ModItems.LETTUCE_SEEDS.get(), lootItemConditionBuilder3));

        LootItemCondition.Builder lootItemConditionBuilder4 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ORANGE_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OrangePlantBlock.AGE, OrangePlantBlock.MAX_AGE));

        this.add(ModBlocks.ORANGE_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.ORANGE_SEEDS_BLOCK.get(),
                ModItems.ORANGE.get(), ModItems.ORANGE_SEEDS.get(), lootItemConditionBuilder4));

        LootItemCondition.Builder lootItemConditionBuilder5 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BROCCOLI_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BroccoliPlantBlock.AGE, BroccoliPlantBlock.MAX_AGE));

        this.add(ModBlocks.BROCCOLI_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.BROCCOLI_SEEDS_BLOCK.get(),
                ModItems.BROCCOLI.get(), ModItems.BROCCOLI_SEEDS.get(), lootItemConditionBuilder5));

        LootItemCondition.Builder lootItemConditionBuilder6 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.CORN_SEEDS_BLOCK.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornPlantBlock.AGE, CornPlantBlock.MAX_AGE));

        this.add(ModBlocks.CORN_SEEDS_BLOCK.get(), this.createCropDrops(ModBlocks.CORN_SEEDS_BLOCK.get(),
                ModItems.CORN.get(), ModItems.CORN_SEEDS.get(), lootItemConditionBuilder6));

        this.dropSelf(ModBlocks.OBSIDIAN_FORGER.get());
        this.dropSelf(ModBlocks.FILTERER.get());
        this.dropSelf(ModBlocks.CRUSHER.get());
        this.dropSelf(ModBlocks.PASTEURIZER.get());
        this.add(ModBlocks.MUD_BLOCK.get(),
                block -> createMudLikeDrops(ModBlocks.MUD_BLOCK.get(), ModItems.MUD_BALL.get()));
        this.add(ModBlocks.DRIED_MUD_BLOCK.get(),
                block -> createMudLikeDrops(ModBlocks.DRIED_MUD_BLOCK.get(), ModItems.DRIED_MUD_BALL.get()));
        this.dropSelf(ModBlocks.COMPRESSED_MUD_BLOCK.get());
        this.add(ModBlocks.SUGAR_BLOCK.get(),
                block -> createMudLikeDrops(ModBlocks.SUGAR_BLOCK.get(), Items.SUGAR));
        this.add(ModBlocks.UNFILTERED_SUGAR_BLOCK.get(),
                block -> createMudLikeDrops(ModBlocks.UNFILTERED_SUGAR_BLOCK.get(), ModItems.UNFILTERED_SUGAR.get()));

        this.dropSelf(ModBlocks.ALLUMINITE_BLOCK.get());
        this.dropSelf(ModBlocks.LUMINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ALLUMINITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LUMINIUM_BLOCK.get());
        this.dropSelf(ModBlocks.REINFORCED_OBSIDIAN.get());

        this.dropSelf(ModBlocks.CATALPA_LOG.get());
        this.dropSelf(ModBlocks.CATALPA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CATALPA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CATALPA_WOOD.get());
        this.dropSelf(ModBlocks.RED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.RED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.add(ModBlocks.CATALPA_LEAVES.get(), this::createFloweringLeavesDrops);
        this.add(ModBlocks.RED_MAPLE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.RED_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.BANANA_LEAVES.get(), this::createBananaLeavesDrops);

        this.add(ModBlocks.CATALPA_SIGN.get(), block ->
                createSingleItemTable(ModItems.CATALPA_SIGN.get()));
        this.add(ModBlocks.CATALPA_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.CATALPA_SIGN.get()));
        this.add(ModBlocks.CATALPA_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CATALPA_HANGING_SIGN.get()));
        this.add(ModBlocks.CATALPA_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.CATALPA_HANGING_SIGN.get()));
        this.add(ModBlocks.RED_MAPLE_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAPLE_SIGN.get()));
        this.add(ModBlocks.RED_MAPLE_WALL_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAPLE_SIGN.get()));
        this.add(ModBlocks.RED_MAPLE_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAPLE_HANGING_SIGN.get()));
        this.add(ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get(), block ->
                createSingleItemTable(ModItems.RED_MAPLE_HANGING_SIGN.get()));

        this.dropSelf(ModBlocks.CATALPA_SAPLING.get());
        this.dropSelf(ModBlocks.RED_MAPLE_SAPLING.get());
        this.dropSelf(ModBlocks.BANANA_SAPLING.get());

        this.add(ModBlocks.CATALPA_FLOWERS.get(), createPetalsDrops(ModBlocks.CATALPA_FLOWERS.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 4F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createAlluminiteLikeOreDrops(Block pBlock, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 1F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createMudLikeDrops(Block pBlock, Item item) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 4F)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    protected LootTable.Builder createPetalsDrops(Block pPetalBlock) {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(this.applyExplosionDecay(pPetalBlock,
                                                LootItem.lootTableItem(pPetalBlock)
                                                        .apply(IntStream.rangeClosed(1, 4).boxed().toList(),
                                                                p_272348_ -> SetItemCountFunction.setCount(ConstantValue.exactly((float) p_272348_.intValue()))
                                                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pPetalBlock)
                                                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PinkPetalsBlock.AMOUNT, p_272348_))
                                                                        )
                                                        )
                                        )
                                )
                );
    }

    private LootTable.Builder createFloweringLeavesDrops(Block block) {
        return LootTable.lootTable()
                .withPool(applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModBlocks.CATALPA_FLOWERS.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.15F))
                        )
                ));
    }

    private LootTable.Builder createBananaLeavesDrops(Block block) {
        return LootTable.lootTable()
                .withPool(applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(LootItem.lootTableItem(ModItems.BANANA.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                                .when(LootItemRandomChanceCondition.randomChance(0.11F))
                        )
                ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::get).collect(Collectors.toList());
    }
}