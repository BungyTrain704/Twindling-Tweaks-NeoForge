package com.austinplays.twindlingtweaks.block.custom.be_blocks.special;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import com.austinplays.twindlingtweaks.block.entity.custom.special_block_entity.PasteurizerBlockEntity;
import com.austinplays.twindlingtweaks.screen.pasteurizer.PasteurizerMenu;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class PasteurizerBlock extends BaseEntityBlock {
    public static final MapCodec<PasteurizerBlock> CODEC = simpleCodec(PasteurizerBlock::new);
    public PasteurizerBlock(Properties pProperties) {
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
            if (blockEntity instanceof PasteurizerBlockEntity) {
                ((PasteurizerBlockEntity) blockEntity).drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof PasteurizerBlockEntity be) {
                MenuProvider provider = new SimpleMenuProvider(
                        (id, playerInventory, _player) -> new PasteurizerMenu(id, playerInventory, be),
                        Component.literal("Pasteurizer") // Replace with whatever name you want shown in the UI
                );

                // Write BlockPos to the buffer so the client can receive it
                serverPlayer.openMenu(new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return Component.literal("Pasteurizer");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
                        return new PasteurizerMenu(id, inv, be);
                    }
                }, (buf) -> buf.writeBlockPos(pos));
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new PasteurizerBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null :
                createTickerHelper(type, ModBlockEntities.PASTEURIZER_BLOCK_ENTITY.get(), PasteurizerBlockEntity::tick);
    }
    @Override
    public MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }
}