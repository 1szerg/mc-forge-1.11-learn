package com.gmail.user0abc.mcforge.examplemod.action;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * @author Sergii Ivanov
 */
public class FlyManager {

    public static void letItFlyABit(final Entity target){
        target.setNoGravity(true);
        target.addVelocity(0,0.5,0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (target) {
                    try {
                        target.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    target.setNoGravity(false);
                }
            }
        }).start();

    }

}
