package com.bungy.twindlingtweaks.entity.custom.sign;

import com.bungy.twindlingtweaks.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity2 extends SignBlockEntity {
    public ModSignBlockEntity2(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MOD_SIGN_2.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_SIGN_2.get();
    }
}