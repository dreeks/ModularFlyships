package xyz.dreeks.modularflyships;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import xyz.dreeks.modularflyships.client.keybinds.MFSKeybinds;
import xyz.dreeks.modularflyships.client.renderer.FlyshipRenderer;

@Environment(EnvType.CLIENT)
public class ModularFlyshipsClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ModularFlyships.MODULAR_FLYSHIP, (dispatcher, context) -> {
            return new FlyshipRenderer(dispatcher);
        });

        MFSKeybinds.initialize();
    }
    
}
