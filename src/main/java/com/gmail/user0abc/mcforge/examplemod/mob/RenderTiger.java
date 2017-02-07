package com.gmail.user0abc.mcforge.examplemod.mob;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

import javax.annotation.Nullable;

/**
 * @author Sergii Ivanov
 */
public class RenderTiger extends RenderLiving<EntityTiger> {

    private static final ResourceLocation texture = new ResourceLocation(ExampleMod.MODID, "textures/entity/tiger/tiger.png");

    public RenderTiger(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelTiger(), 1f);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(EntityTiger entity) {
        return texture;
    }

    protected void preRenderCallback(EntityTiger entityLivingBaseIn, float partialTickTime) {
        super.preRenderCallback(entityLivingBaseIn, partialTickTime);
    }

    public static IRenderFactory<EntityTiger> getRenderFactory() {
        return new IRenderFactory<EntityTiger>() {
            @Override
            public Render createRenderFor(RenderManager manager) {
                return new RenderTiger(manager);
            }
        };
    }
}
