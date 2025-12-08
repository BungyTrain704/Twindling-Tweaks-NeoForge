package com.bungy.twindlingtweaks.util.block_entity_util;

import com.bungy.twindlingtweaks.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;

import java.util.Map;

public class PasteurizerEffectMap {
    public static final Map<Holder<MobEffect>, Item> EFFECT_ITEM_MAP = Map.of(
            MobEffects.FIRE_RESISTANCE, ModItems.GOAT_ICE_CREAM.get(),
            MobEffects.DAMAGE_BOOST, ModItems.GOAT_BUTTER.get(),
            MobEffects.BAD_OMEN, ModItems.VANILLA_GOAT_YOGURT.get(),
            MobEffects.MOVEMENT_SPEED, ModItems.GOAT_CHEESE.get()
            // Add more as needed
    );
}
