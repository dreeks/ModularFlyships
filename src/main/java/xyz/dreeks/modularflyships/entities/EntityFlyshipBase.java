package xyz.dreeks.modularflyships.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityFlyshipBase extends Entity {

    private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.createKey(EntityFlyshipBase.class, DataSerializers.VARINT);
    private static final DataParameter<Float> MAX_HEALTH = EntityDataManager.createKey(EntityFlyshipBase.class, DataSerializers.FLOAT);


    public EntityFlyshipBase(World worldIn) {
        super(worldIn);
        this.setSize(1f, 1f);
        this.stepHeight = 2.0f;
    }

    @Override
    protected void entityInit() {
        this.dataManager.register(TIME_SINCE_HIT, 0);
        this.dataManager.register(MAX_HEALTH, 100F);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

}
