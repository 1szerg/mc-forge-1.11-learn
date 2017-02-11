package com.gmail.user0abc.mcforge.examplemod.action;

import com.gmail.user0abc.mcforge.examplemod.mob.EntityTiger;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.datafix.fixes.MinecartEntityTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

/**
 * @author Sergii Ivanov
 */
public class ExampleEvents {

    @SubscribeEvent
    public void killMob(LivingDeathEvent event) {
        System.out.println("Death: "+event.getEntity()+" - "+event.getEntity().getName());
        final World world = event.getEntity().getEntityWorld();
        final Entity entity = event.getEntity();
        if(!world.isRemote && entity instanceof EntityOcelot){
            final Random random = new Random();
            if(world.countEntities(EntityTiger.class) < 1 && random.nextInt(100) > 0){
                System.out.println("ALARM! "+event.getEntity()+" - "+event.getEntity().getName());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (this){
                            try {
                                this.wait(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        EntityTiger tiger = new EntityTiger(world);
                        tiger.setPositionAndRotation(entity.posX+random.nextInt(32)-16, entity.posY, entity.posZ+random.nextInt(32)-16, entity.rotationYaw, entity.rotationPitch);
                        world.spawnEntity(tiger);
                        System.out.println("SPAWN! "+tiger);
                    }
                }).start();
            }
        }
    }
}
