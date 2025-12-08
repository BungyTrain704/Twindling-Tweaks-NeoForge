package com.bungy.twindlingtweaks.block.entity;

import com.bungy.twindlingtweaks.TwindlingTweaks;
import com.bungy.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity;
import com.bungy.twindlingtweaks.entity.custom.boat.ModBoatEntity;
import com.bungy.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.bungy.twindlingtweaks.entity.custom.chest_boat.ModChestBoatEntity;
import com.bungy.twindlingtweaks.entity.custom.chest_boat.ModChestBoatEntity2;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TwindlingTweaks.MOD_ID);

    // Regular boats
    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat",
                    () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(ModBoatEntity.ATTACHMENTS_NBT_KEY));

    public static final DeferredHolder<EntityType<?>, EntityType<ModBoatEntity2>> MOD_BOAT_2 =
            ENTITY_TYPES.register("mod_boat_2",
                    () -> EntityType.Builder.<ModBoatEntity2>of(ModBoatEntity2::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(ModBoatEntity2.ATTACHMENTS_NBT_KEY));

    // Chest boats
    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat",
                    () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(ModChestBoatEntity.ATTACHMENTS_NBT_KEY));

    public static final DeferredHolder<EntityType<?>, EntityType<ModChestBoatEntity2>> MOD_CHEST_BOAT_2 =
            ENTITY_TYPES.register("mod_chest_boat_2",
                    () -> EntityType.Builder.<ModChestBoatEntity2>of(ModChestBoatEntity2::new, MobCategory.MISC)
                            .sized(1.375f, 0.5625f)
                            .build(ModChestBoatEntity2.ATTACHMENTS_NBT_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}