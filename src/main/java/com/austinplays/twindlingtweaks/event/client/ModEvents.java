package com.austinplays.twindlingtweaks.event.client;

import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.CrusherBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.FiltererBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.ObsidianForgerBlockEntity;
import com.austinplays.twindlingtweaks.block.entity.custom.special_block_entity.PasteurizerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = "twindlingtweaks")
public class ModEvents {

    @SubscribeEvent
    public static void onRightClickCrusherBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof CrusherBlockEntity crusher) {
                crusher.interact(serverPlayer);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // stop vanilla processing
            }
        }
    }
    @SubscribeEvent
    public static void onRightClickFiltererBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof FiltererBlockEntity filterer) {
                filterer.interact(serverPlayer);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // stop vanilla processing
            }
        }
    }
    @SubscribeEvent
    public static void onRightClickObsidianForgerBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ObsidianForgerBlockEntity obsidianForger) {
                obsidianForger.interact(serverPlayer);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // stop vanilla processing
            }
        }
    }
    @SubscribeEvent
    public static void onRightClickPasteurizerBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof PasteurizerBlockEntity pasteurizer) {
                pasteurizer.interact(serverPlayer);
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true); // stop vanilla processing
            }
        }
    }
}