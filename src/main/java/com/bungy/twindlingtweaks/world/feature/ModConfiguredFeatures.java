package com.bungy.twindlingtweaks.world.feature;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_KEY = registerKey("red_maple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CATALPA_KEY = registerKey("catalpa");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BANANA_KEY = registerKey("banana");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH_KEY = registerKey("blueberry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RASPBERRY_BUSH_KEY = registerKey("raspberry_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LUMINIUM_ORE_KEY = registerKey("overworld_luminium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALLUMINITE_ORE_KEY = registerKey("overworld_alluminite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MUD_ORE_KEY = registerKey("overworld_mud_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SUGAR_ORE_KEY = registerKey("overworld_sugar_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SALT_ORE_KEY = registerKey("overworld_salt_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldLuminiumOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.LUMINIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_LUMINIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldAlluminiteOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.ALLUMINITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALLUMINITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldMudOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.MUD_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MUD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSugarOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SUGAR_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SUGAR_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> overworldSaltOres = List.of(OreConfiguration.target(stoneReplaceable,
                        ModBlocks.SALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_LUMINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLuminiumOres, 7));
        register(context, OVERWORLD_ALLUMINITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAlluminiteOres, 14));
        register(context, OVERWORLD_MUD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMudOres, 16));
        register(context, OVERWORLD_SUGAR_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSugarOres, 15));
        register(context, OVERWORLD_SALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSaltOres, 12));

        register(context, CATALPA_KEY, Feature.TREE, createCatalpa().build());
        register(context, RED_MAPLE_KEY, Feature.TREE, createRedMaple().build());
        register(context, BANANA_KEY, Feature.TREE, createBanana().build());

        register(context, BLUEBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                ), List.of(Blocks.GRASS_BLOCK)));

        register(context, RASPBERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        BlockStateProvider.simple(ModBlocks.RASPBERRY_BUSH.get()
                                .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                ), List.of(Blocks.GRASS_BLOCK)));

    }
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block pLogBlock, Block pLeavesBlock, int pBaseHeight, int pHeightRandA, int pHeightRandB, int pRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(pLogBlock), new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB), BlockStateProvider.simple(pLeavesBlock), new BlobFoliagePlacer(ConstantInt.of(pRadius), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1));
    }
        private static TreeConfiguration.TreeConfigurationBuilder createCatalpaTree(Block pLogBlock, Block pLeavesBlock, int pBaseHeight, int pHeightRandA, int pHeightRandB) {
            return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(pLogBlock), new StraightTrunkPlacer(pBaseHeight, pHeightRandA, pHeightRandB),
                    BlockStateProvider.simple(pLeavesBlock), new CherryFoliagePlacer(ConstantInt.of(4),
                    ConstantInt.of(0),
                    ConstantInt.of(5),
                    0.25F, 0.5F, 0.16666667F, 0.33333334F), new TwoLayersFeatureSize(1, 0, 2));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createBasicCherryTree(Block pLogBlock, Block pLeavesBlock) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(pLogBlock), new CherryTrunkPlacer(7,
                1,
                0,
                new WeightedListInt(
                        SimpleWeightedRandomList.<IntProvider>builder()
                                .add(ConstantInt.of(1), 1)
                                .add(ConstantInt.of(2), 1)
                                .add(ConstantInt.of(3), 1)
                                .build()
                ),
                UniformInt.of(2, 4),
                UniformInt.of(-4, -3),
                UniformInt.of(-1, 0)),
                BlockStateProvider.simple(pLeavesBlock),
                new CherryFoliagePlacer(ConstantInt.of(4),
                        ConstantInt.of(0),
                        ConstantInt.of(5),
                        0.25F, 0.5F, 0.16666667F, 0.33333334F),
                new TwoLayersFeatureSize(1, 0, 2));
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createCatalpa() {
        return createCatalpaTree(ModBlocks.CATALPA_LOG.get(), ModBlocks.CATALPA_LEAVES.get(), 4, 3, 0).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createRedMaple() {
        return createBasicCherryTree(ModBlocks.RED_MAPLE_LOG.get(), ModBlocks.RED_MAPLE_LEAVES.get()).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createBanana() {
        return createStraightBlobTree(Blocks.OAK_LOG, ModBlocks.BANANA_LEAVES.get(), 4, 2, 0, 2).ignoreVines();
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

