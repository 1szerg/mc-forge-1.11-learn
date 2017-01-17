package com.gmail.user0abc.mcforge.examplemod;

import net.minecraft.init.Items;
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
    }

}
