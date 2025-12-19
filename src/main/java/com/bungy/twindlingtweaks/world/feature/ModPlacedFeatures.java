package com.bungy.twindlingtweaks.world.feature;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> RED_MAPLE_PLACED_KEY = createKey("red_maple_placed");
    public static final ResourceKey<PlacedFeature> CATALPA_PLACED_KEY = createKey("catalpa_placed");
    public static final ResourceKey<PlacedFeature> BANANA_PLACED_KEY = createKey("banana_placed");

    public static final ResourceKey<PlacedFeature> BLUEBERRY_BUSH_PLACED_KEY = createKey("blueberry_bush_placed");
    public static final ResourceKey<PlacedFeature> RASPBERRY_BUSH_PLACED_KEY = createKey("raspberry_bush_placed");

    public static final ResourceKey<PlacedFeature> ALLUMINITE_PLACED_KEY = createKey("alluminite_placed");
    public static final ResourceKey<PlacedFeature> LUMINIUM_PLACED_KEY = createKey("luminium_placed");
    public static final ResourceKey<PlacedFeature> MUD_PLACED_KEY = createKey("mud_placed");
    public static final ResourceKey<PlacedFeature> SALT_PLACED_KEY = createKey("salt_placed");
    public static final ResourceKey<PlacedFeature> SUGAR_PLACED_KEY = createKey("sugar_placed");

    public static Holder.Reference<PlacedFeature> RED_MAPLE_PLACED = null;
    public static Holder.Reference<PlacedFeature> CATALPA_PLACED = null;
    public static Holder.Reference<PlacedFeature> BANANA_PLACED = null;

    public static Holder.Reference<PlacedFeature> BLUEBERRY_BUSH_PLACED = null;
    public static Holder.Reference<PlacedFeature> RASPBERRY_BUSH_PLACED = null;

    public static Holder.Reference<PlacedFeature> ALLUMINITE_PLACED = null;
    public static Holder.Reference<PlacedFeature> LUMINIUM_PLACED = null;
    public static Holder.Reference<PlacedFeature> SUGAR_PLACED = null;
    public static Holder.Reference<PlacedFeature> MUD_PLACED = null;
    public static Holder.Reference<PlacedFeature> SALT_PLACED = null;

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        RED_MAPLE_PLACED = register(context, RED_MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RED_MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.005f,  2), ModBlocks.RED_MAPLE_SAPLING.get()));

        CATALPA_PLACED = register(context, CATALPA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CATALPA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.005f, 2), ModBlocks.CATALPA_SAPLING.get()));

        BANANA_PLACED = register(context, BANANA_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BANANA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlocks.BANANA_SAPLING.get()));


        BLUEBERRY_BUSH_PLACED = register(context, BLUEBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(128), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        RASPBERRY_BUSH_PLACED = register(context, RASPBERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RASPBERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(128), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


        LUMINIUM_PLACED = register(context, LUMINIUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_LUMINIUM_ORE_KEY),
                commonOrePlacement(7, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        ALLUMINITE_PLACED = register(context, ALLUMINITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ALLUMINITE_ORE_KEY),
                commonOrePlacement(15, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        MUD_PLACED = register(context, MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MUD_ORE_KEY),
                commonOrePlacement(10, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        SUGAR_PLACED = register(context, SUGAR_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SUGAR_ORE_KEY),
                commonOrePlacement(10, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        SALT_PLACED = register(context, SALT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SALT_ORE_KEY),
                commonOrePlacement(11, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));


    }
        public static List<PlacementModifier> orePlacement (PlacementModifier p_195347_, PlacementModifier p_195348_){
            return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
        }

        public static List<PlacementModifier> commonOrePlacement ( int p_195344_, PlacementModifier p_195345_){
            return orePlacement(CountPlacement.of(p_195344_), p_195345_);
        }

        public static List<PlacementModifier> rareOrePlacement ( int p_195350_, PlacementModifier p_195351_){
            return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
        }
        private static ResourceKey<PlacedFeature> createKey (String name){
            return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
        }
    private static Holder.Reference<PlacedFeature> register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                            Holder<ConfiguredFeature<?, ?>> configuration,
                                                            List<PlacementModifier> modifiers) {
        return context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}