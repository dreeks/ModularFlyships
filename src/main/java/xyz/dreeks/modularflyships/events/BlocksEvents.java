package xyz.dreeks.modularflyships.events;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.dreeks.modularflyships.blocks.IHasItem;
import xyz.dreeks.modularflyships.blocks.MFSBlocks;
import xyz.dreeks.modularflyships.items.MFSItems;
import xyz.dreeks.modularflyships.utils.Constants;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class BlocksEvents {

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        final IForgeRegistry<Block> registry = event.getRegistry();

        for (Block b : MFSBlocks.blocks) {
            registry.register(b);
        }
    }

}
