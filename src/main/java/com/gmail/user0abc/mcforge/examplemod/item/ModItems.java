package com.gmail.user0abc.mcforge.examplemod.item;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author Sergii Ivanov
 */
public class ModItems {

    public static Item exampleItem;

    public static void preInit() {
        exampleItem = new ExampleItem(EnumHelper.addToolMaterial("Example", 3, 100, 1.0F, 1.0F, 40)).setUnlocalizedName("example_item").setCreativeTab(ExampleMod.tabExample);
        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(exampleItem, new ResourceLocation(ExampleMod.MODID, "example_item"));
    }

    public static void registerRenders() {
        registerItem(exampleItem);
    }

    public static void registerItem(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(ExampleMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
