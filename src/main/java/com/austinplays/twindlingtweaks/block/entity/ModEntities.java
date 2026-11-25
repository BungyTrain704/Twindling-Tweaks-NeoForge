package com.austinplays.twindlingtweaks.block.entity;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.austinplays.twindlingtweaks.entity.custom.chest_boat.ModChestBoatEntity;
import com.austinplays.twindlingtweaks.entity.custom.chest_boat.ModChestBoatEntity2;
import com.austinplays.twindlingtweaks.entity.custom.throwable.MudBallProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TwindlingTweaks.MOD_ID);

    public static ResourceKey<EntityType<?>> MOD_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("mod_boat"));
    public static ResourceKey<EntityType<?>> MOD_BOAT_2_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("mod_boat_2"));
    public static ResourceKey<EntityType<?>> MOD_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("mod_chest_boat"));
    public static ResourceKey<EntityType<?>> MOD_CHEST_BOAT_2_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("mod_chest_boat_2"));
    public static ResourceKey<EntityType<?>> MUD_BALL_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("mud_ball"));
    // Regular boats
    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("catalpa_boat",
                    () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(MOD_BOAT_KEY));

    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity2>> MOD_BOAT_2 =
            ENTITY_TYPES.register("red_maple_boat",
                    () -> EntityType.Builder.<ModBoatEntity2>of(ModBoatEntity2::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(MOD_BOAT_2_KEY));

    // Chest boats
    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("catalpa_chest_boat",
                    () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(MOD_CHEST_BOAT_KEY));

    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity2>> MOD_CHEST_BOAT_2 =
            ENTITY_TYPES.register("red_maple_chest_boat",
                    () -> EntityType.Builder.<ModChestBoatEntity2>of(ModChestBoatEntity2::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(MOD_CHEST_BOAT_2_KEY));

    public static final DeferredHolder<EntityType<?>, EntityType<MudBallProjectileEntity>> MUD_BALL =
            ENTITY_TYPES.register("mud_ball", () ->
                    EntityType.Builder.<MudBallProjectileEntity>of(MudBallProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build(MUD_BALL_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}