package com.bungy.twindlingtweaks.block.custom.hanging_sign.wall;

import com.bungy.twindlingtweaks.entity.custom.hanging_sign.ModHangingSignBlockEntity2;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWallHangingSignBlock2 extends WallHangingSignBlock {
    public ModWallHangingSignBlock2(Properties pProperties, WoodType pType) {
        super(pType, pProperties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity2(pPos, pState);
    }
}