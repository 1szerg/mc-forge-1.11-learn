package com.gmail.user0abc.mcforge.examplemod.item;

import com.gmail.user0abc.mcforge.examplemod.action.FlyManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * @author Sergii Ivanov
 */
public class ExampleItem extends ItemSword {

    public ExampleItem(ToolMaterial material) {
        super(material);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.getBlockState(pos).getBlock() == Blocks.GRASS) {
            worldIn.setBlockState(pos, Blocks.STONE.getDefaultState());
            player.sendMessage(new TextComponentString("hit " + hitX + ", " + hitY + ", " + hitZ));
            return EnumActionResult.SUCCESS;
        }
        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public boolean hitEntity(ItemStack stack, final EntityLivingBase target, EntityLivingBase attacker) {
        FlyManager.letItFlyABit(target);
//        target.setNoGravity(true);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (target) {
//                    try {
//                        target.wait(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    target.setNoGravity(false);
//                }
//            }
//        }).start();
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote) {
            playerIn.sendMessage(new TextComponentString("Air"));
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
