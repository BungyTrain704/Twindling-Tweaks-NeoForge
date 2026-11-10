package com.austinplays.twindlingtweaks.entity.client;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CATALPA_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "boat/catalpa"), "main");
    public static final ModelLayerLocation CATALPA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "chest_boat/catalpa"), "main");

    public static final ModelLayerLocation RED_MAPLE_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "boat/red_maple"), "main");
    public static final ModelLayerLocation RED_MAPLE_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, "chest_boat/red_maple"), "main");
}
