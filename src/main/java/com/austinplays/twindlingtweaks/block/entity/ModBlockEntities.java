package com.austinplays.twindlingtweaks.block.entity;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.CrusherBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.FiltererBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.ObsidianForgerBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity2;
import com.austinplays.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity3;
import com.austinplays.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity4;
import com.austinplays.twindlingtweaks.block.entity.custom.special_block_entity.PasteurizerBlockEntity;
import com.austinplays.twindlingtweaks.entity.custom.hanging_sign.ModHangingSignBlockEntity;
import com.austinplays.twindlingtweaks.entity.custom.hanging_sign.ModHangingSignBlockEntity2;
import com.austinplays.twindlingtweaks.entity.custom.sign.ModSignBlockEntity;
import com.austinplays.twindlingtweaks.entity.custom.sign.ModSignBlockEntity2;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TwindlingTweaks.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ObsidianForgerBlockEntity>> OBSIDIAN_FORGER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("obsidian_forger_block_entity", () ->
                    new BlockEntityType<>(ObsidianForgerBlockEntity::new,
                            ModBlocks.OBSIDIAN_FORGER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FiltererBlockEntity>> FILTERER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("filterer_block_entity", () ->
                    new BlockEntityType<>(FiltererBlockEntity::new,
                            ModBlocks.FILTERER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrusherBlockEntity>> CRUSHER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("crusher_block_entity", () ->
                    new BlockEntityType<>(CrusherBlockEntity::new,
                            ModBlocks.CRUSHER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PasteurizerBlockEntity>> PASTEURIZER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("pasteurizer_block_entity", () ->
                    new BlockEntityType<>(PasteurizerBlockEntity::new,
                            ModBlocks.PASTEURIZER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    new BlockEntityType<>(ModSignBlockEntity::new,
                            ModBlocks.CATALPA_SIGN.get(), ModBlocks.CATALPA_WALL_SIGN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    new BlockEntityType<>(ModHangingSignBlockEntity::new,
                            ModBlocks.CATALPA_HANGING_SIGN.get(), ModBlocks.CATALPA_WALL_HANGING_SIGN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity2>> MOD_SIGN_2 =
            BLOCK_ENTITIES.register("mod_sign_2", () ->
                    new BlockEntityType<>(ModSignBlockEntity2::new,
                            ModBlocks.RED_MAPLE_SIGN.get(), ModBlocks.RED_MAPLE_WALL_SIGN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity2>> MOD_HANGING_SIGN_2 =
            BLOCK_ENTITIES.register("mod_hanging_sign_2", () ->
                    new BlockEntityType<>(ModHangingSignBlockEntity2::new,
                            ModBlocks.RED_MAPLE_HANGING_SIGN.get(), ModBlocks.RED_MAPLE_WALL_HANGING_SIGN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModFarmlandBlockEntity>> SPEEDY_FARMLAND_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("speedy_farmland", () ->
                    new BlockEntityType<>(ModFarmlandBlockEntity::new,
                            ModBlocks.SPEEDY_FARMLAND.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModFarmlandBlockEntity2>> FLASH_FARMLAND_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("flash_farmland", () ->
                    new BlockEntityType<>(ModFarmlandBlockEntity2::new,
                            ModBlocks.FLASH_FARMLAND.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModFarmlandBlockEntity3>> FIERY_FARMLAND_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("fiery_farmland", () ->
                    new BlockEntityType<>(ModFarmlandBlockEntity3::new,
                            ModBlocks.FIERY_FARMLAND.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModFarmlandBlockEntity4>> TTWEAKS_FARMLAND_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("twindling_tweaks_farmland", () ->
                    new BlockEntityType<>(ModFarmlandBlockEntity4::new,
                            ModBlocks.TWINDLING_TWEAKS_FARMLAND.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}