package com.gmail.user0abc.mcforge.examplemod.block;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author Sergii Ivanov
 */
public class ModBlocks {
    public static Block exampleBlock;

    public static void preInit() {
        exampleBlock = new ExampleBlock(Material.ROCK, "example_block");
        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(exampleBlock);
    }

    public static void registerBlock(Block block){
        GameRegistry.register(block, new ResourceLocation(ExampleMod.MODID, block.getUnlocalizedName().substring(5)));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(ExampleMod.MODID, block.getUnlocalizedName().substring(5)));
    }

    public static void registerRenders(){
        registerRender(exampleBlock);
    }

    public static void registerRender(Block block){
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(ExampleMod.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory")
        );
    }
}
