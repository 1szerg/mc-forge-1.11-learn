package com.gmail.user0abc.mcforge.examplemod.block;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import com.gmail.user0abc.mcforge.examplemod.action.FlyManager;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/**
 * @author Sergii Ivanov
 */
public class ExampleBlock extends Block {

    public static final String BLOCK_NAME = "example_block";

    public ExampleBlock() {
        super(Material.ROCK);
        setUnlocalizedName("example_block");
        setCreativeTab(ExampleMod.tabExample);
        setHardness(10F);
        setResistance(100F);
        setSoundType(SoundType.METAL);
        setLightLevel(1F);
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, Blocks.TNT.getDefaultState());
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        worldIn.spawnEntity(new EntityBlaze(worldIn));
        super.onBlockDestroyedByExplosion(worldIn, pos, explosionIn);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        FlyManager.letItFlyABit(entityIn);
        super.onEntityWalk(worldIn, pos, entityIn);
    }


}
