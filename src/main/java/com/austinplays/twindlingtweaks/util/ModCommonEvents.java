package com.austinplays.twindlingtweaks.util;

import com.austinplays.twindlingtweaks.TwindlingTweaks;
import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = TwindlingTweaks.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {

    @SubscribeEvent
    public static void onGoatMilked(PlayerInteractEvent.EntityInteractSpecific event) {
        if (!(event.getTarget() instanceof Goat goat)) return;
        if (!(event.getItemStack().getItem() == Items.BUCKET)) return;

        Level level = event.getLevel();
        Player player = event.getEntity();

        // Server-side only
        if (!level.isClientSide()) {
            ItemStack goatMilk = new ItemStack(ModItems.GOAT_MILK.get());

            // Remove empty bucket if not in creative
            if (!player.isCreative()) {
                event.getItemStack().shrink(1);
            }

            // Give player the custom milk item
            if (!player.getInventory().add(goatMilk)) {
                player.drop(goatMilk, false);
            }

            level.playSound(null, goat, SoundEvents.COW_MILK, SoundSource.PLAYERS, 1.0F, 1.0F);
        }

        // Cancel the original milk interaction
        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}