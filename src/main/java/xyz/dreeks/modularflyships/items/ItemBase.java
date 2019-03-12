package xyz.dreeks.modularflyships.items;

import net.minecraft.item.Item;
import xyz.dreeks.modularflyships.ModularFlyships;

public class ItemBase extends Item {

    public ItemBase(String name) {
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModularFlyships.instance.tab);
    }

}
