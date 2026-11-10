package com.austinplays.twindlingtweaks.item.custom.armor.handler;

import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "twindlingtweaks")
public class AlluminiteArmorEffectHandler {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.level().isClientSide()) return;

        int count = 0;
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.is(ModItems.ALLUMINITE_HELMET.get())
                    && stack.is(ModItems.ALLUMINITE_CHESTPLATE.get())
                    && stack.is(ModItems.ALLUMINITE_LEGGINGS.get())
                    && stack.is(ModItems.ALLUMINITE_BOOTS.get())) {
                count++;
            }
        }

        if (count > 0) {

            int amplifier = count - 1; // 1 piece = 0, 4 pieces = 3
            int duration = 300;

            MobEffectInstance existing = player.getEffect(MobEffects.NIGHT_VISION);

            // Apply ONLY if missing or about to expire
            if (existing == null || existing.getDuration() <= 220 || !existing.isAmbient()) {
                player.addEffect(new MobEffectInstance(
                        MobEffects.NIGHT_VISION,
                        duration,
                        amplifier,
                        true,  // ambient = true → identifies as armor effect
                        false, // particles
                        true   // icon
                ));
            }

        } else {
            MobEffectInstance existing = player.getEffect(MobEffects.NIGHT_VISION);

            if (existing != null && existing.isAmbient()) {
                // Only removes the armor's version, not potion/beacon/etc.
                player.removeEffect(MobEffects.NIGHT_VISION);
            }
        }
    }
}