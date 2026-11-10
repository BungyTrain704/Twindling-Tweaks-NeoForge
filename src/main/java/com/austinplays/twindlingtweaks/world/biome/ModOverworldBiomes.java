package com.austinplays.twindlingtweaks.world.biome;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Mth;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModOverworldBiomes {
    private static void addFeature(BiomeGenerationSettings.Builder builder, GenerationStep.Decoration step, ResourceKey<PlacedFeature> feature) {
        builder.addFeature(step, feature);
    }

    public static Biome catalpaGrove(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        // Mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder, 30);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);

        // Biome features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true).temperature(0.35F).downfall(0.48F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3F76E4).waterFogColor(0x050533).fogColor(0xC0D8FF)
                        .skyColor(calculateSkyColor(0.7F)).grassColorOverride(0x7FB238).foliageColorOverride(0x6DA36D).build())
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    public static Biome redMapleForest(HolderGetter<PlacedFeature> placedFeatureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        // Mob spawns
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder, 30);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);

        // Biome features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatureGetter, carverGetter);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true).temperature(0.2F).downfall(0.4F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3F76E4).waterFogColor(0x050533).fogColor(0xC0D8FF)
                        .skyColor(calculateSkyColor(0.6F)).grassColorOverride(0xB04A2F).foliageColorOverride(0xC43C2B).build())
                .mobSpawnSettings(spawnBuilder.build()).generationSettings(biomeBuilder.build()).build();
    }

    protected static int calculateSkyColor(float temperature) {
        float $$1 = temperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }
}