package com.gmail.user0abc.mcforge.examplemod.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * @author Sergii Ivanov
 */
public class CreativeTabExample extends CreativeTabs {

    public CreativeTabExample(int index, String label) {
        super(index, label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.ARROW);
    }
}
