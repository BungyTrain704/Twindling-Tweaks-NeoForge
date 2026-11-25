package com.austinplays.twindlingtweaks.entity.custom.throwable;

import com.austinplays.twindlingtweaks.block.entity.ModEntities;
import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.EntityHitResult;

public class MudBallProjectileEntity extends ThrowableItemProjectile {

    public MudBallProjectileEntity(EntityType<? extends MudBallProjectileEntity> type, Level level) {
        super(type, level);
    }

    public MudBallProjectileEntity(Level level, LivingEntity shooter) {
        super(
                ModEntities.MUD_BALL.get(),
                shooter,
                level,
                new ItemStack(ModItems.MUD_BALL.get())
        );
    }

    public MudBallProjectileEntity(Level level, double x, double y, double z) {
        super(
                ModEntities.MUD_BALL.get(),
                x,
                y,
                z,
                level,
                new ItemStack(ModItems.MUD_BALL.get())
        );
    }


    @Override
    protected Item getDefaultItem() {
        return ModItems.MUD_BALL.get();
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!this.level().isClientSide) {
            if (result.getEntity() instanceof LivingEntity living) {
                living.addEffect(new MobEffectInstance(
                        MobEffects.MOVEMENT_SLOWDOWN, // Slowness
                        100, // 5 seconds
                        1    // Slowness II
                ));
                living.hurt(this.damageSources().thrown(this, this.getOwner()), 0.0f);
            }

            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            for (int i = 0; i < 8; ++i) {
                this.level().addParticle(
                        new BlockParticleOption(ParticleTypes.BLOCK, Blocks.MUD.defaultBlockState()),
                        this.getX(),
                        this.getY(),
                        this.getZ(),
                        0.0D, 0.0D, 0.0D
                );
            }
        }
    }
}