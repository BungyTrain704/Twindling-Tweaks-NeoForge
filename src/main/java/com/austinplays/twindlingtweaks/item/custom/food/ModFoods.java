package com.austinplays.twindlingtweaks.item.custom.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties LETTUCE = (new FoodProperties.Builder().nutrition(1).saturationModifier(.8F)).build();

    public static final Consumable LETTUCE_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 2), 0.35f)).build();

    public static final FoodProperties ORANGE = (new FoodProperties.Builder().nutrition(3).saturationModifier(1.2F).build());

    public static final Consumable ORANGE_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 0.5f)).build();

    public static final FoodProperties SALAD = (new FoodProperties.Builder().nutrition(6).saturationModifier(1.4F).build());

    public static final Consumable SALAD_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 3), 1f)).build();

    public static final FoodProperties DRIED_MUD_BALL = (new FoodProperties.Builder().nutrition(2).alwaysEdible().saturationModifier(.2F).build());

    public static final Consumable DRIED_MUD_BALL_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 1), 0.8f)).build();

    public static final FoodProperties CROUTON = (new FoodProperties.Builder().nutrition(1).saturationModifier(1F).build());

    public static final FoodProperties BROCCOLI = (new FoodProperties.Builder().nutrition(3).saturationModifier(0.8F).build());

    public static final FoodProperties TOMATO = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.8F).build());

    public static final FoodProperties CORN = (new FoodProperties.Builder().nutrition(6).saturationModifier(0.8F).build());

    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.8F).build());

    public static final Consumable CUCUMBER_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1), 0.8f)).build();

    public static final FoodProperties BANANA = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.6F).build());

    public static final FoodProperties LUMINIUM_APPLE = (new FoodProperties.Builder().nutrition(3).alwaysEdible().saturationModifier(2F).build());

    public static final Consumable LUMINIUM_APPLE_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000, 4), 10f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1400, 1), 10f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 1), 10f)).build();

    public static final FoodProperties KETCHUP_BOTTLE = (new FoodProperties.Builder().nutrition(3).saturationModifier(.1F).build());

    public static final FoodProperties CRUSHED_TOMATO = (new FoodProperties.Builder().nutrition(2).saturationModifier(.05F).build());

    public static final FoodProperties BREAD_SLICE = (new FoodProperties.Builder().nutrition(2).saturationModifier(1.1F).build());

    public static final FoodProperties STEAK_LETTUCE_SANDWICH = (new FoodProperties.Builder().nutrition(9).saturationModifier(1.5F).build());

    public static final Consumable STEAK_LETTUCE_SANDWICH_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800, 2), 10f)).build();

    public static final FoodProperties TOASTED_STEAK_LETTUCE_SANDWICH = (new FoodProperties.Builder().nutrition(11).saturationModifier(1.5F).build());

    public static final Consumable TOASTED_STEAK_LETTUCE_SANDWICH_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 2), 10f)).build();

    public static final FoodProperties GOAT_CHEESE = (new FoodProperties.Builder().nutrition(5).saturationModifier(1.1F).build());

    public static final FoodProperties SLICED_GOAT_CHEESE = (new FoodProperties.Builder().nutrition(3).saturationModifier(0.6F).build());

    public static final FoodProperties VANILLA_GOAT_YOGURT = (new FoodProperties.Builder().nutrition(3).saturationModifier(1.4F).build());

    public static final Consumable VANILLA_GOAT_YOGURT_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 700, 1), 100f)).build();

    public static final FoodProperties GOAT_ICE_CREAM = (new FoodProperties.Builder().nutrition(4).saturationModifier(1.6F).build());

    public static final FoodProperties GOAT_BUTTER = (new FoodProperties.Builder().nutrition(3).saturationModifier(0.1F).build());

    public static final Consumable GOAT_BUTTER_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.CONFUSION, 550, 2), 100f)).build();

    public static final FoodProperties HEARTY_STEW = (new FoodProperties.Builder().nutrition(9).saturationModifier(1.7F).build());

    public static final Consumable HEARTY_STEW_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 800, 2), 100f)).build();

    public static final FoodProperties BOILED_EGG = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_BEEF = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_PORKCHOP = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_CHICKEN = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F).build());

    public static final Consumable SALTED_RAW_CHICKEN_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, 900, 0), 0.1f)).build();

    public static final FoodProperties SALTED_RAW_MUTTON = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_RABBIT = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_COD = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build());

    public static final FoodProperties SALTED_RAW_SALMON = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build());

    public static final FoodProperties TOAST = (new FoodProperties.Builder().nutrition(2).saturationModifier(0.9F).build());

    public static final FoodProperties CHIPS = (new FoodProperties.Builder().nutrition(6).saturationModifier(1.9F).build());

    public static final FoodProperties CHEESE_MEAT_SANDWICH = (new FoodProperties.Builder().nutrition(14).saturationModifier(1.5F).build());

    public static final FoodProperties VEGAN_SANDWICH = (new FoodProperties.Builder().nutrition(7).saturationModifier(1F).build());

    public static final Consumable VEGAN_SANDWICH_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 10f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 1), 10f)).build();

    public static final FoodProperties MEATY_SANDWICH = (new FoodProperties.Builder().nutrition(12).saturationModifier(1F).build());

    public static final Consumable MEATY_SANDWICH_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000, 1), 10f)).build();

    public static final FoodProperties BLUEBERRY = (new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).build());

    public static final FoodProperties RASPBERRY = (new FoodProperties.Builder().nutrition(4).saturationModifier(0.4F).build());

    public static final FoodProperties SPRING_SALAD = (new FoodProperties.Builder().nutrition(7).saturationModifier(1.4F).build());

    public static final Consumable SPRING_SALAD_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 3), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 900, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 6), 1.0f)).build();

    public static final FoodProperties SPECIAL_SALAD = (new FoodProperties.Builder().nutrition(9).saturationModifier(1.5F).build());

    public static final Consumable SPECIAL_SALAD_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 700, 1), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 700, 1), 1.0f)).build();

    public static final FoodProperties BERRY_BOWL = (new FoodProperties.Builder().nutrition(5).saturationModifier(0.9F).build());

    public static final Consumable BERRY_BOWL_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600, 2), 0.85f)).build();

    public static final FoodProperties BERRY_TOAST = (new FoodProperties.Builder().nutrition(4).saturationModifier(1.1F).build());

    public static final FoodProperties BANANA_SANDWICH = (new FoodProperties.Builder().nutrition(5).saturationModifier(1.3F).build());
}


