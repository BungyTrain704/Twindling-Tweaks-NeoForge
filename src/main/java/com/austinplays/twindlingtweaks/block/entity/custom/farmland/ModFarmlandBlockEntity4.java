package com.austinplays.twindlingtweaks.block.entity.custom.farmland;

import com.austinplays.twindlingtweaks.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModFarmlandBlockEntity4 extends BlockEntity {
    private Block lastCrop;


    public ModFarmlandBlockEntity4(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TTWEAKS_FARMLAND_BLOCK_ENTITY.get(), pos, state);
    }

    public void setLastCrop(Block crop) {
        this.lastCrop = crop;
        setChanged();
    }

    public Block getLastCrop() {
        return lastCrop;
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        if (lastCrop != null) {
            tag.putString("LastCrop", BuiltInRegistries.BLOCK.getKey(lastCrop).toString());
        }
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        if (tag.contains("LastCrop")) {
            lastCrop = BuiltInRegistries.BLOCK
                    .get(ResourceLocation.parse(tag.getString("LastCrop")))
                    .map(Holder.Reference::value)
                    .orElse(null);
        }
    }
}