package com.austinplays.twindlingtweaks.item.custom.milk;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ModMilkBucketItem3 extends MilkBucketItem {
    private static final int DRINK_DURATION = 32;

    public ModMilkBucketItem3(Item.Properties pProperties) {
        super(pProperties);
    }



    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) pEntityLiving.removeAllEffects(); // FORGE - move up so stack.shrink does not turn stack into air
        if (pEntityLiving instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
            if (pEntityLiving instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, pStack);
                serverplayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 900, 2));
                serverplayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1400, 2));
                serverplayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 1));
            }
        }

        if (pEntityLiving instanceof Player && !((Player)pEntityLiving).getAbilities().instabuild) {
            pStack.shrink(1);
        }

        return pStack.isEmpty() ? new ItemStack(Items.BUCKET) : pStack;
    }

    public int getUseDuration(ItemStack pStack) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
}
