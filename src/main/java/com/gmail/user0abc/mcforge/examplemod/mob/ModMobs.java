package com.gmail.user0abc.mcforge.examplemod.mob;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @author Sergii Ivanov
 */
public class ModMobs {

    public static void registerMobs() {
        registerMob(EntityTiger.class, "tiger");
    }

    public static int registerMob(Class entityClass, String entityName) {
        int id = 201;
        ResourceLocation rl = new ResourceLocation(ExampleMod.MODID, entityName);
        EntityRegistry.registerModEntity(rl, EntityTiger.class, entityName, id, ExampleMod.instance, 16, 1, true);
        EntityList.ENTITY_EGGS.put(rl, new EntityList.EntityEggInfo(rl, 0xf4b342, 0x000000));
        return id;
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTiger.class, RenderTiger.getRenderFactory());
    }

}
