package com.austinplays.twindlingtweaks.entity.client.renderers.boat;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.austinplays.twindlingtweaks.entity.custom.chest_boat.ModChestBoatEntity2;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.Map;
import java.util.stream.Stream;

public class ModBoatRenderer2 extends BoatRenderer {
    private final Map<ModBoatEntity2.Type, Pair<ResourceLocation, ListModel<Boat>>> boatResources;

    public ModBoatRenderer2(EntityRendererProvider.Context pContext, boolean pChestBoat) {
        super(pContext, pChestBoat);
        this.boatResources = Stream.of(ModBoatEntity2.Type.values()).collect(ImmutableMap.toImmutableMap(type -> type,
                type -> Pair.of(ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, getTextureLocation(type, pChestBoat)), this.createBoatModel(pContext, type, pChestBoat))));
    }

    private static String getTextureLocation(ModBoatEntity2.Type pType, boolean pChestBoat) {
        return pChestBoat ? "textures/entity/chest_boat/" + pType.getName() + ".png" : "textures/entity/boat/" + pType.getName() + ".png";
    }

    private ListModel<Boat> createBoatModel(EntityRendererProvider.Context pContext, ModBoatEntity2.Type pType, boolean pChestBoat) {
        ModelLayerLocation modellayerlocation = pChestBoat ? ModBoatRenderer2.createChestBoatModelName(pType) : ModBoatRenderer2.createBoatModelName(pType);
        ModelPart modelpart = pContext.bakeLayer(modellayerlocation);
        return pChestBoat ? new ChestBoatModel(modelpart) : new BoatModel(modelpart);
    }

    public static ModelLayerLocation createBoatModelName(ModBoatEntity2.Type pType) {
        return createLocation("boat/" + pType.getName(), "main");
    }

    public static ModelLayerLocation createChestBoatModelName(ModBoatEntity2.Type pType) {
        return createLocation("chest_boat/" + pType.getName(), "main");
    }

    private static ModelLayerLocation createLocation(String pPath, String pModel) {
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(TwindlingTweaks.MOD_ID, pPath), pModel);
    }

    public Pair<ResourceLocation, ListModel<Boat>> getModelWithLocation(Boat boat) {
        if(boat instanceof ModBoatEntity2 modBoat) {
            return this.boatResources.get(modBoat.getModVariant());
        } else if(boat instanceof ModChestBoatEntity2 modChestBoatEntity2) {
            return this.boatResources.get(modChestBoatEntity2.getModVariant());
        } else {
            return null;
        }
    }
}