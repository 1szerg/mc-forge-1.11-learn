package com.gmail.user0abc.mcforge.examplemod.mob;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * @author Sergii Ivanov
 */
public class EntityTiger extends EntityMob {

    public static String NAME = "tiger";

    public EntityTiger(World worldIn) {
        super(worldIn);
        this.setSize(0.9f, 0.9f);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        int ownTaskOrder = 0;
        this.tasks.addTask(ownTaskOrder++, new EntityAILeapAtTarget(this, 0.5f));
        this.tasks.addTask(ownTaskOrder++, new EntityAIAttackMelee(this, 1.0f, true));
        this.tasks.addTask(ownTaskOrder++, new EntityAISwimming(this));
        this.tasks.addTask(ownTaskOrder++, new EntityAIMoveTowardsTarget(this, 0.75f, 40f));
        this.tasks.addTask(ownTaskOrder++, new EntityAIWatchClosest(this, EntityPlayer.class, 40f));
        this.tasks.addTask(ownTaskOrder++, new EntityAIWanderAvoidWater(this, 0.5f));
        this.tasks.addTask(ownTaskOrder++, new EntityAIWander(this, 0.5f));
        this.tasks.addTask(ownTaskOrder++, new EntityAILookIdle(this));
        int targetTaskOrder = 0;
        this.targetTasks.addTask(targetTaskOrder++, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(targetTaskOrder++, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120f);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75f);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5f);
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40f);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
    }

    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        return super.onInitialSpawn(difficulty, livingdata);
    }

}
