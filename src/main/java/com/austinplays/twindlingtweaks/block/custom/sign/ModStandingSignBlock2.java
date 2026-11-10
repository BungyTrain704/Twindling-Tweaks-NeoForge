package com.austinplays.twindlingtweaks.block.custom.sign;

import com.austinplays.twindlingtweaks.entity.custom.sign.ModSignBlockEntity2;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock2 extends StandingSignBlock {
    public ModStandingSignBlock2(Properties pProperties, WoodType pType) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModSignBlockEntity2(pPos, pState);
    }
}