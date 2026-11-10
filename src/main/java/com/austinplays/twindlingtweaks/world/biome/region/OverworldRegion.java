package com.austinplays.twindlingtweaks.world.biome.region;

import com.austinplays.twindlingtweaks.world.biome.ModBiomes;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class OverworldRegion extends Region {

    public OverworldRegion(ResourceLocation name) {
        super(name, RegionType.OVERWORLD, 4); // rare region
    }

    @Override
    public void addBiomes(
            Registry<Biome> registry,
            Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper
    ) {

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.WARM)
                .humidity(ParameterUtils.Humidity.WET)
                .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.HIGH_SLICE_NORMAL_ASCENDING)
                .build()
                .forEach(p ->
                        mapper.accept(Pair.of(p, ModBiomes.CATALPA_GROVE))
                );

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.COOL)
                .humidity(ParameterUtils.Humidity.NEUTRAL)
                .continentalness(ParameterUtils.Continentalness.MID_INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING)
                .build()
                .forEach(p ->
                        mapper.accept(Pair.of(p, ModBiomes.RED_MAPLE_FOREST))
                );
    }
}