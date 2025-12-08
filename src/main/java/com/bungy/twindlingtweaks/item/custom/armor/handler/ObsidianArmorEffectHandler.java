package com.bungy.twindlingtweaks.item.custom.armor.handler;

import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "twindlingtweaks")
public class ObsidianArmorEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) return;

        int count = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.is(ModItems.OBSIDIAN_HELMET.get())
                    || stack.is(ModItems.OBSIDIAN_CHESTPLATE.get())
                    || stack.is(ModItems.OBSIDIAN_LEGGINGS.get())
                    || stack.is(ModItems.OBSIDIAN_BOOTS.get())) {
                count++;
            }
        }

        if (count > 0) {

            int amplifier = count - 1;
            int duration = 300;

            MobEffectInstance slow = player.getEffect(MobEffects.MOVEMENT_SLOWDOWN);
            if (slow == null || slow.getDuration() <= 220 || !slow.isAmbient()) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SLOWDOWN,
                        duration,
                        amplifier,
                        true,
                        false,
                        true
                ));
            }

            MobEffectInstance res = player.getEffect(MobEffects.DAMAGE_RESISTANCE);
            if (res == null || res.getDuration() <= 220 || !res.isAmbient()) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.DAMAGE_RESISTANCE,
                        duration,
                        amplifier,
                        true,
                        false,
                        true
                ));
            }

        } else {

            MobEffectInstance slow = player.getEffect(MobEffects.MOVEMENT_SLOWDOWN);
            if (slow != null && slow.isAmbient()) {
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }

            MobEffectInstance res = player.getEffect(MobEffects.DAMAGE_RESISTANCE);
            if (res != null && res.isAmbient()) {
                player.removeEffect(MobEffects.DAMAGE_RESISTANCE);
            }
        }
    }
}