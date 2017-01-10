package com.gmail.user0abc.mcforge.examplemod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Sergii Ivanov
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Server: Pre init " + System.currentTimeMillis());
    }

    public void init(FMLInitializationEvent event) {
        System.out.println("Server: Init " + System.currentTimeMillis());
    }

    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Server: Post init " + System.currentTimeMillis());
    }
}
