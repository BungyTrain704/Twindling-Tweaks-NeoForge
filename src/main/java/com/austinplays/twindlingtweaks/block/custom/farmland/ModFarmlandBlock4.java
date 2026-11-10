package com.austinplays.twindlingtweaks.block.custom.farmland;

import com.austinplays.twindlingtweaks.block.ModBlocks;
import com.austinplays.twindlingtweaks.block.entity.custom.farmland.ModFarmlandBlockEntity4;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModFarmlandBlock4 extends FarmBlock implements EntityBlock {

    public static final IntegerProperty MOISTURE = FarmBlock.MOISTURE;
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

    public ModFarmlandBlock4(Properties properties, @NotNull Block block) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 0));
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return !this.defaultBlockState().canSurvive(pContext.getLevel(), pContext.getClickedPos()) ? ModBlocks.ALLUMIN_LUMINIUM_DIRT.get().defaultBlockState() : super.getStateForPlacement(pContext);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);

        if (!state.canSurvive(level, pos)) {
            turnToDirt(null, state, level, pos);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        int moisture = state.getValue(MOISTURE);
        if (!isNearWater(level, pos) && !level.isRainingAt(pos.above())) {
            if (moisture > 0) {
                level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(moisture - 1)), 2);
            } else if (!shouldMaintainFarmland(level, pos)) {
                turnToDirt(null, state, level, pos);
            }
        } else if (moisture < 7) {
            level.setBlock(pos, state.setValue(MOISTURE, Integer.valueOf(7)), 2);
        }

        // Crop growth boost logic
        BlockPos above = pos.above();
        BlockState cropState = level.getBlockState(above);
        if (cropState.getBlock() instanceof CropBlock cropBlock && !cropBlock.isMaxAge(cropState)) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ModFarmlandBlockEntity4 farmlandBe) {
                Block lastCrop = farmlandBe.getLastCrop();
                Block currentCrop = cropState.getBlock();

                farmlandBe.setLastCrop(currentCrop);

                float speedMultiplier = 1.4f;
                if (lastCrop != null && lastCrop != currentCrop) {
                    speedMultiplier = 1.8f;
                }

                if (random.nextFloat() < (1.35f * speedMultiplier)) {
                    cropBlock.growCrops(level, above, cropState);
                }
            }
        }
    }

    public static void turnToDirt(@javax.annotation.Nullable Entity pEntity, @NotNull BlockState pState, Level pLevel, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(pState, ModBlocks.ALLUMIN_LUMINIUM_DIRT.get().defaultBlockState(), pLevel, pPos);
        pLevel.setBlockAndUpdate(pPos, blockstate);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
    }

    private static boolean shouldMaintainFarmland(BlockGetter pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.above()).is(BlockTags.MAINTAINS_FARMLAND);
    }

    private static boolean hasCrops(BlockState state) {
        return state.getBlock() instanceof CropBlock;
    }

    private static boolean isNearWater(LevelReader level, BlockPos pos) {
        for (BlockPos nearby : BlockPos.betweenClosed(pos.offset(-4, 0, -4), pos.offset(4, 1, 4))) {
            if (level.getFluidState(nearby).is(Fluids.WATER)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (!level.isClientSide && net.neoforged.neoforge.common.CommonHooks.onFarmlandTrample(level, pos, ModBlocks.ALLUMIN_LUMINIUM_DIRT.get().defaultBlockState(), fallDistance, entity)) {
            turnToDirt(entity, state, level, pos);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ModFarmlandBlockEntity4(pos, state);
    }

    public void appendHoverText(ItemStack pStack, Item.TooltipContext tooltipContext, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("Has an extremely high chance to instantly grow crops!"));
        super.appendHoverText(pStack, tooltipContext, pTooltip, pFlag);
    }
}