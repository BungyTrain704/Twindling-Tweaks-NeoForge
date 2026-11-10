package com.austinplays.twindlingtweaks.world.biomemods;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.util.ModTags;
import com.austinplays.twindlingtweaks.world.biome.ModBiomes;
import com.austinplays.twindlingtweaks.world.feature.ModPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;

import java.util.Collections;

import static net.neoforged.neoforge.registries.NeoForgeRegistries.Keys.BIOME_MODIFIERS;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_ALLUMINITE_ORE = registerKey("add_alluminite_ore");
    public static final ResourceKey<BiomeModifier> ADD_LUMINIUM_ORE = registerKey("add_luminium_ore");
    public static final ResourceKey<BiomeModifier> ADD_MUD_ORE = registerKey("add_mud_ore");
    public static final ResourceKey<BiomeModifier> ADD_SUGAR_ORE = registerKey("add_sugar_ore");
    public static final ResourceKey<BiomeModifier> ADD_SALT_ORE = registerKey("add_salt_ore");

    public static final ResourceKey<BiomeModifier> ADD_TREE_CATALPA = registerKey("add_tree_catalpa");
    public static final ResourceKey<BiomeModifier> ADD_TREE_RED_MAPLE = registerKey("add_tree_red_maple");

    public static final ResourceKey<BiomeModifier> ADD_TREE_BANANA = registerKey("add_tree_banana");

    public static final ResourceKey<BiomeModifier> ADD_BLUEBERRY_BUSH = registerKey("add_blueberry_bush");
    public static final ResourceKey<BiomeModifier> ADD_RASPBERRY_BUSH = registerKey("add_raspberry_bush");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_ALLUMINITE_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALLUMINITE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_LUMINIUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LUMINIUM_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_MUD_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MUD_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SUGAR_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SUGAR_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_SALT_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SALT_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        context.register(ADD_TREE_CATALPA, new BiomeModifiers.AddFeaturesBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(ModBiomes.CATALPA_GROVE)),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CATALPA_PLACED_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_RED_MAPLE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(ModBiomes.RED_MAPLE_FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RED_MAPLE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TREE_BANANA, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BANANA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUEBERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.BLUEBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_RASPBERRY_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST), biomes.getOrThrow(Biomes.BIRCH_FOREST),
                        biomes.getOrThrow(Biomes.JUNGLE)),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.RASPBERRY_BUSH_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
    }
}