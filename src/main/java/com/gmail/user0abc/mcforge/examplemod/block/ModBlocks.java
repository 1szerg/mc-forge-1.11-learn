package com.gmail.user0abc.mcforge.examplemod.block;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import net.minecraft.block.Block;
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
    public static Block breakerBlock;
    public static Block breakerBlockOn;

    public static void preInit() {
        exampleBlock = new ExampleBlock();
        breakerBlock = new BlockBreaker(false);
        breakerBlockOn = new BlockBreaker(true);
        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(exampleBlock, ExampleBlock.BLOCK_NAME);
        registerBlock(breakerBlock, BlockBreaker.NAME_OFF);
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(ExampleMod.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(ExampleMod.MODID, name));
    }

    public static void registerRenders() {
        registerRender(exampleBlock, ExampleBlock.BLOCK_NAME);
        registerRender(breakerBlock, BlockBreaker.NAME_OFF);
    }

    public static void registerRender(Block block, String name) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0,
                new ModelResourceLocation(ExampleMod.MODID + ":" + name, "inventory")
        );
    }
}
