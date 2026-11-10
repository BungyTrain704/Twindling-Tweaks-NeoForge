package com.austinplays.twindlingtweaks.block.custom.cake;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class ModCakeBlock extends CakeBlock {
    public ModCakeBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (level.isClientSide) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return eat(level, pos, state, player);
    }

    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }

        player.awardStat(Stats.EAT_CAKE_SLICE);
        player.getFoodData().eat(2, 0.1F);
        int bites = state.getValue(BITES);

        if (!level.isClientSide()) {
            if (bites < 6) {
                // Not the last slice — Speed I (amplifier 0), 15s
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 15 * 20, 0));
                level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
            } else {
                // Last slice — Speed III (amplifier 2), 3 minutes
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60 * 3 * 20, 2));
                level.removeBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }
        }

        level.gameEvent(player, GameEvent.EAT, pos);
        return InteractionResult.SUCCESS;
    }


    public void appendHoverText(ItemStack pStack, Item.TooltipContext ptooltipContext, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("Make sure to finish your food for a bonus!"));
        super.appendHoverText(pStack, ptooltipContext, pTooltip, pFlag);

    }
}
