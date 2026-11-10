package com.austinplays.twindlingtweaks.entity.client.renderers.throwable;

import com.austinplays.twindlingtweaks.entity.custom.throwable.MudBallProjectileEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class MudBallProjectileRenderer extends ThrownItemRenderer<MudBallProjectileEntity> {

    public MudBallProjectileRenderer(EntityRendererProvider.Context context) {
        super(context, 1.0F, true);
    }
}