package xyz.dreeks.modularflyships.events;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.dreeks.modularflyships.entities.MFSEntities;
import xyz.dreeks.modularflyships.utils.Constants;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID)
public class EntityEvents {

    @SubscribeEvent
    public void registerEntity(RegistryEvent.Register<EntityEntry> event) {
        final IForgeRegistry<EntityEntry> registry = event.getRegistry();

        for (EntityEntry ee : MFSEntities.entities) {
            registry.register(ee);
        }
    }

}
