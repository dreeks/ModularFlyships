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
public class ItemEvents {

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        for (Item i : MFSItems.items) {
            registry.register(i);
        }

        for (Block b : MFSBlocks.blocks) {
            if (b instanceof IHasItem && ((IHasItem) b).hasItem()) {
                registry.register(new ItemBlock(b).setRegistryName(b.getRegistryName()));
            }
        }
    }

}
