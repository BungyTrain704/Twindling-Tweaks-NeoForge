package com.bungy.twindlingtweaks.block.custom.leaf;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BananaLeavesBlock extends LeavesBlock {
    public static final IntegerProperty BANANA_VARIANT = IntegerProperty.create("bananas", 0, 3);

    public BananaLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, Boolean.FALSE)
                .setValue(BANANA_VARIANT, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(BANANA_VARIANT);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Randomly choose a banana variant when placed
        int randomVariant = context.getLevel().getRandom().nextInt(4); // 0–3
        return this.defaultBlockState()
                .setValue(PERSISTENT, true)
                .setValue(BANANA_VARIANT, randomVariant);
    }
}