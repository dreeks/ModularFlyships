package xyz.dreeks.modularflyships.items;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.dreeks.modularflyships.entities.EntityFlyshipBase;

public class ItemFlyship extends ItemBase {

    public ItemFlyship() {
        super("flyship");
    }

    /**
     *
     * @MEMO onItemRightClick works, onItemUse does not
     *
     */

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer playerIn, EnumHand handIn) {
        if (!world.isRemote) {
            //EntityCow efb = new EntityCow(world); // Also returns false (:
            EntityFlyshipBase efb = new EntityFlyshipBase(world);
            efb.posX = playerIn.posX;
            efb.posY = playerIn.posY + 1.0d;
            efb.posZ = playerIn.posZ;

            System.out.println(world.spawnEntity(efb)); // False

        }

        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            //EntityCow efb = new EntityCow(world); // Also returns false (:
            EntityFlyshipBase efb = new EntityFlyshipBase(world);
            efb.posX = hitX;
            efb.posY = hitY + 1.0d;
            efb.posZ = hitZ;

            //System.out.println(world.spawnEntity(efb)); // False

            return EnumActionResult.SUCCESS;
        }

        return EnumActionResult.PASS;
    }

}
