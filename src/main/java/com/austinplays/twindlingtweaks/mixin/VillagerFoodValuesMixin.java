package com.austinplays.twindlingtweaks.mixin;

import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Mixin(Villager.class)
public abstract class VillagerFoodValuesMixin {

    @Shadow @Final @Mutable
    private static Map<Item, Integer> FOOD_POINTS;

    @Shadow @Final @Mutable
    private static Set<Item> WANTED_ITEMS;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void twindlingtweaks$extendVillagerFood(CallbackInfo ci) {
        // ---- FOOD POINTS ----
        Map<Item, Integer> food = new HashMap<>(FOOD_POINTS);
        food.put(ModItems.CUCUMBER.get(), 1);
        food.put(ModItems.TOMATO.get(), 1);
        food.put(ModItems.LETTUCE.get(), 1);
        food.put(ModItems.ORANGE.get(), 1);
        food.put(ModItems.BROCCOLI.get(), 1);
        food.put(ModItems.CORN.get(), 1);
        FOOD_POINTS = Map.copyOf(food);

        // ---- WANTED ITEMS ----
        Set<Item> wanted = new HashSet<>(WANTED_ITEMS);
        wanted.add(ModItems.CUCUMBER.get());
        wanted.add(ModItems.TOMATO.get());
        wanted.add(ModItems.LETTUCE.get());
        wanted.add(ModItems.ORANGE.get());
        wanted.add(ModItems.BROCCOLI.get());
        wanted.add(ModItems.CORN.get());
        WANTED_ITEMS = Set.copyOf(wanted);
    }
}