package com.austinplays.twindlingtweaks.entity.custom.hanging_sign;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity2 extends SignBlockEntity {
    public ModHangingSignBlockEntity2(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MOD_HANGING_SIGN_2.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_HANGING_SIGN_2.get();
    }
}