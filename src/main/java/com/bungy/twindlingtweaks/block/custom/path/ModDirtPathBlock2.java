package com.bungy.twindlingtweaks.block.custom.path;

import com.bungy.twindlingtweaks.block.ModBlocks;
import com.bungy.twindlingtweaks.block.custom.farmland.ModFarmlandBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ModDirtPathBlock2 extends Block {
    public static final MapCodec<ModDirtPathBlock2> CODEC = simpleCodec(ModDirtPathBlock2::new);
    protected static final VoxelShape SHAPE = ModFarmlandBlock.SHAPE;

    @Override
    public MapCodec<ModDirtPathBlock2> codec() {
        return CODEC;
    }

    public ModDirtPathBlock2(Properties p_153129_) {
        super(p_153129_);
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return !this.defaultBlockState().canSurvive(placeContext.getLevel(), placeContext.getClickedPos())
                ? pushEntitiesUp(this.defaultBlockState(), ModBlocks.YELLOW_DIRT.get().defaultBlockState(), placeContext.getLevel(), placeContext.getClickedPos())
                : super.getStateForPlacement(placeContext);
    }

    @Override
    protected BlockState updateShape(
            BlockState p_153152_, Direction p_153153_, BlockState p_153154_, LevelAccessor p_153155_, BlockPos p_153156_, BlockPos p_153157_
    ) {
        if (p_153153_ == Direction.UP && !p_153152_.canSurvive(p_153155_, p_153156_)) {
            p_153155_.scheduleTick(p_153156_, this, 1);
        }

        return super.updateShape(p_153152_, p_153153_, p_153154_, p_153155_, p_153156_, p_153157_);
    }

    @Override
    protected void tick(BlockState p_221070_, ServerLevel p_221071_, BlockPos p_221072_, RandomSource p_221073_) {
        turnToDirt(null, p_221070_, p_221071_, p_221072_);
    }

    @Override
    protected boolean canSurvive(BlockState p_153148_, LevelReader p_153149_, BlockPos p_153150_) {
        BlockState blockstate = p_153149_.getBlockState(p_153150_.above());
        return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
    }

    @Override
    protected VoxelShape getShape(BlockState p_153143_, BlockGetter p_153144_, BlockPos p_153145_, CollisionContext p_153146_) {
        return SHAPE;
    }

    @Override
    protected boolean isPathfindable(BlockState p_153138_, PathComputationType p_153141_) {
        return false;
    }

    public static void turnToDirt(@javax.annotation.Nullable Entity pEntity, @NotNull BlockState pState, Level pLevel, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(pState, ModBlocks.YELLOW_DIRT.get().defaultBlockState(), pLevel, pPos);
        pLevel.setBlockAndUpdate(pPos, blockstate);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
    }
}