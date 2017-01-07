package com.gmail.user0abc.mcforge.examplemod;

import com.gmail.user0abc.mcforge.examplemod.proxy.CommonProxy;
import com.gmail.user0abc.mcforge.examplemod.tab.CreativeTabExample;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    public static final String NAME = "Example Mod";

    @SidedProxy(clientSide = "com.gmail.user0abc.mcforge.examplemod.proxy.ClientProxy", serverSide = "com.gmail.user0abc.mcforge.examplemod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static ExampleMod instance;
    public static CreativeTabExample tabExample;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        tabExample = new CreativeTabExample(CreativeTabs.getNextID(), "tab_example");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("\nInit "+System.currentTimeMillis()+"\n");
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        System.out.println("\nPost init "+System.currentTimeMillis()+"\n");
    }
}
