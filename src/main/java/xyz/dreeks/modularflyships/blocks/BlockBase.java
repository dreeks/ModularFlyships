package xyz.dreeks.modularflyships.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import xyz.dreeks.modularflyships.ModularFlyships;

public class BlockBase extends Block {

    public BlockBase(String name, Material material, MapColor mapColor) {
        super(material, mapColor);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setCreativeTab(ModularFlyships.tab);
    }

}
