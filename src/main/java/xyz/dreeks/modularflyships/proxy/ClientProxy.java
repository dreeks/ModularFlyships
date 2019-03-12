package xyz.dreeks.modularflyships.proxy;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import xyz.dreeks.modularflyships.entities.EntityFlyshipBase;
import xyz.dreeks.modularflyships.entities.RenderFlyshipBase;

public class ClientProxy extends CommonProxy {

    @Override
    public void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFlyshipBase.class, RenderFlyshipBase::new);
    }

    @Override
    public boolean isClient() {
        return true;
    }

}
