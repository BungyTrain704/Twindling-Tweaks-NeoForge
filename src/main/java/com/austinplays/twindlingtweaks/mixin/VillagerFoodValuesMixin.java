package com.austinplays.twindlingtweaks.mixin;

import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Mixin(Villager.class)
public abstract class VillagerFoodValuesMixin {

    @Shadow
    @Final
    @Mutable
    private static Map<Item, Integer> FOOD_POINTS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void twindlingtweaks$extendVillagerFood(CallbackInfo ci) {
        Map<Item, Integer> food = new HashMap<>(FOOD_POINTS);

        food.put(ModItems.CUCUMBER.get(), 1);
        food.put(ModItems.TOMATO.get(), 1);
        food.put(ModItems.LETTUCE.get(), 1);
        food.put(ModItems.ORANGE.get(), 1);
        food.put(ModItems.BROCCOLI.get(), 1);
        food.put(ModItems.CORN.get(), 1);

        FOOD_POINTS = Map.copyOf(food);
    }
}