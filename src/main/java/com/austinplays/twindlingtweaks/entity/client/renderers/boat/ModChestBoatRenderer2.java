package com.austinplays.twindlingtweaks.entity.client.renderers.boat;

import com.austinplays.twindlingtweaks.entity.client.ModModelLayers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ModChestBoatRenderer2 extends BoatRenderer {

    public ModChestBoatRenderer2(EntityRendererProvider.Context context) {
        super(context, ModModelLayers.RED_MAPLE_CHEST_BOAT_LAYER);
    }
}