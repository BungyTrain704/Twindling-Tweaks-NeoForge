package com.austinplays.twindlingtweaks.world.biome;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.world.biome.region.OverworldRegion;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import terrablender.api.Regions;

public class ModBiomes {
    public static final ResourceKey<Biome> CATALPA_GROVE = registerBiomeKey("catalpa_grove");
    public static final ResourceKey<Biome> RED_MAPLE_FOREST = registerBiomeKey("red_maple_forest");

    public static Holder<Biome> CATALPA_HOLDER = null;
    public static Holder<Biome> RED_MAPLE_HOLDER = null;

    public static void registerBiomes() {
        Regions.register(new OverworldRegion(ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "twindlingtweaks_overworld")));
    }

    public static void bootstrap(BootstrapContext<Biome> context) {
        var carver = context.lookup(Registries.CONFIGURED_CARVER);
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        CATALPA_HOLDER = context.register(CATALPA_GROVE, ModOverworldBiomes.catalpaGrove(placedFeatures, carver));
        RED_MAPLE_HOLDER = context.register(RED_MAPLE_FOREST, ModOverworldBiomes.redMapleForest(placedFeatures, carver));
    }


    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
    }

    private static ResourceKey<Biome> registerBiomeKey(String name) {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, name));
    }
}