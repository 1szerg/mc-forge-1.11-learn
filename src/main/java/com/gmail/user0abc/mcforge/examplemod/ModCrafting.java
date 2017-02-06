package com.gmail.user0abc.mcforge.examplemod;

import com.gmail.user0abc.mcforge.examplemod.block.ModBlocks;
import com.gmail.user0abc.mcforge.examplemod.item.ExampleItem;
import com.gmail.user0abc.mcforge.examplemod.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * @author Sergii Ivanov
 */
public class ModCrafting {
    public static void registerRecipes() {
        registerCraftingRecipes();
        registerSmeltingRecipes();
    }

    private static void registerCraftingRecipes() {

    }

    private static void registerSmeltingRecipes() {
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), 0f);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.breakerBlock), "ISI", "SGS", "IPI",
                'I', Items.IRON_INGOT, 'S', Blocks.STONE, 'G', ModItems.exampleItem, 'P', Items.DIAMOND_PICKAXE);

    }

}
