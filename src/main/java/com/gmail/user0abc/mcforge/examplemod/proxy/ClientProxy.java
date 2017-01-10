package com.gmail.user0abc.mcforge.examplemod.proxy;

import com.gmail.user0abc.mcforge.examplemod.block.ModBlocks;
import com.gmail.user0abc.mcforge.examplemod.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Sergii Ivanov
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println("Client: Pre init " + System.currentTimeMillis());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        System.out.println("Client: Init " + System.currentTimeMillis());
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("Client: Post init " + System.currentTimeMillis());
    }
}
