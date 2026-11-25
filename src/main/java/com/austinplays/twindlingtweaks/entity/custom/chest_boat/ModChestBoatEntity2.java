package com.austinplays.twindlingtweaks.entity.custom.chest_boat;

import com.austinplays.twindlingtweaks.block.entity.ModEntities;
import com.austinplays.twindlingtweaks.entity.custom.boat.ModBoatEntity2;
import com.austinplays.twindlingtweaks.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity2 extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity2.class, EntityDataSerializers.INT);

    public ModChestBoatEntity2(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel, ModItems.RED_MAPLE_CHEST_BOAT);
    }

    public ModChestBoatEntity2(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.MOD_CHEST_BOAT_2.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    public void setVariant(ModBoatEntity2.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_ID_TYPE, ModBoatEntity2.Type.RED_MAPLE.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity2.Type.byName(pCompound.getString("Type")));
        }
    }

    public ModBoatEntity2.Type getModVariant() {
        return ModBoatEntity2.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}