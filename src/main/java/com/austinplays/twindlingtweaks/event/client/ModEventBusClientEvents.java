package com.austinplays.twindlingtweaks.event.client;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.entity.client.ModModelLayers;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = TwindlingTweaks.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CATALPA_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.CATALPA_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
        event.registerLayerDefinition(ModModelLayers.RED_MAPLE_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModModelLayers.RED_MAPLE_CHEST_BOAT_LAYER,BoatModel::createChestBoatModel);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {

        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN_2.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN_2.get(), HangingSignRenderer::new);
    }
}