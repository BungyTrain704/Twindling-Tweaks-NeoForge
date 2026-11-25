package com.austinplays.twindlingtweaks.entity.client.renderers.boat;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.entity.client.ModModelLayers;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ModChestBoatRenderer extends BoatRenderer {

    public ModChestBoatRenderer(EntityRendererProvider.Context context) {
        super(context, ModModelLayers.CATALPA_CHEST_BOAT_LAYER);
    }
}