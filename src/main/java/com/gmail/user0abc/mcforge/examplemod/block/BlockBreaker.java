package com.gmail.user0abc.mcforge.examplemod.block;

import com.gmail.user0abc.mcforge.examplemod.ExampleMod;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * @author Sergii Ivanov
 */
public class BlockBreaker extends BlockDirectional {

    public static final PropertyBool ACTIVE = PropertyBool.create("active");
    public static final String NAME_OFF = "breaker_block";
    public static final String NAME_ON = "breaker_block_on";

    public BlockBreaker(boolean isEnabled) {
        super(Material.ROCK);
        setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(ACTIVE, isEnabled));
        setUnlocalizedName("breaker");
        setCreativeTab(ExampleMod.tabExample);
        setHardness(10F);
        setResistance(100F);
        setSoundType(SoundType.STONE);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        setDirection(worldIn, pos, state);
    }

    private void setDirection(World worldIn, BlockPos pos, IBlockState state) {
        worldIn.setBlockState(pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(ModBlocks.breakerBlock);
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        super.updateTick(worldIn, pos, state, rand);
//        if (state.getValue(ACTIVE)) {
//            worldIn.setBlockState(pos, state.withProperty(ACTIVE, false));
//            harvestBlock(worldIn, pos, state);
//        }
    }

    private void harvestBlock(World worldIn, BlockPos pos, IBlockState state) {
        BlockPos target = null;
        switch (state.getValue(FACING)){
            case DOWN:
                target = pos.down();break;
            case UP:
                target = pos.up();break;
            case EAST:
                target = pos.east();break;
            case NORTH:
                target = pos.north();break;
            case WEST:
                target = pos.west();break;
            case SOUTH:
                target = pos.south();break;
            }
        if(target != null){
            worldIn.destroyBlock(target, true);
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
//        System.out.println(
//                "onNeighborChange\n ("+pos+") "+world.getBlockState(pos).getBlock()+ ":" + world.getBlockState(pos).getProperties()+
//                " \n ("+neighbor+") "+world.getBlockState(neighbor).getBlock()+" : "+world.getBlockState(neighbor).getProperties()
//        );

    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!state.getValue(ACTIVE) && worldIn.isBlockPowered(pos)) {
            worldIn.setBlockState(pos, state.withProperty(ACTIVE, true));
            harvestBlock(worldIn, pos, state);
        }else if(state.getValue(ACTIVE) && !worldIn.isBlockPowered(pos)){
            worldIn.setBlockState(pos, state.withProperty(ACTIVE, false));
        }
    }

    @Override
    public BlockStateContainer getBlockState() {
        return super.getBlockState();
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
        return super.getExtendedState(state, world, pos);
    }



    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, @Nullable EnumFacing side) {
        return true;
    }

    @Override
    public boolean canBeReplacedByLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, ACTIVE});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, getFacingFromMeta(meta)).withProperty(ACTIVE, getEnabledFromMeta(meta));
    }

    private boolean getEnabledFromMeta(int meta) {
        return (meta & 8) == 8;
    }

    private EnumFacing getFacingFromMeta(int meta) {
        int dir = meta - (meta & 8);
        return EnumFacing.getFront(dir);
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

        if (state.getValue(ACTIVE))
        {
            i |= 8;
        }

        return i;
    }


}
