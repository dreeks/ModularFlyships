package xyz.dreeks.modularflyships.utils;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MFSCreativeTabs extends CreativeTabs {

    public MFSCreativeTabs() {
        super("mfs.name");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BAKED_POTATO, 1);
    }

}
