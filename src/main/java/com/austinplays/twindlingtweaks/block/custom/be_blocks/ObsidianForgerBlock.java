package com.austinplays.twindlingtweaks.block.custom.be_blocks;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.block.entity.custom.block_entity.ObsidianForgerBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ObsidianForgerBlock extends BaseEntityBlock {
    public static final MapCodec<ObsidianForgerBlock> CODEC = simpleCodec(ObsidianForgerBlock::new);
    public ObsidianForgerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ObsidianForgerBlockEntity) {
                ((ObsidianForgerBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ObsidianForgerBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.OBSIDIAN_FORGER_BLOCK_ENTITY.get(),
                ObsidianForgerBlockEntity::tick);
    }
    @Override
    public MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}