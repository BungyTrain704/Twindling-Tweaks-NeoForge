package com.austinplays.twindlingtweaks.block.custom.hanging_sign;

import com.austinplays.twindlingtweaks.entity.custom.hanging_sign.ModHangingSignBlockEntity2;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModHangingSignBlock2 extends CeilingHangingSignBlock {
    public ModHangingSignBlock2(Properties pProperties, WoodType pType) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity2(pPos, pState);
    }
}