package xyz.dreeks.modularflyships;

import org.lwjgl.glfw.GLFW;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import xyz.dreeks.modularflyships.client.renderer.FlyshipRenderer;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;
import xyz.dreeks.modularflyships.model.PressedKey;

@Environment(EnvType.CLIENT)
public class ModularFlyshipsClient implements ClientModInitializer {

    public static KeyBinding downKey;

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(ModularFlyships.MODULAR_FLYSHIP, (dispatcher, context) -> {
            return new FlyshipRenderer(dispatcher);
        });

        downKey = KeyBindingHelper.registerKeyBinding(new net.minecraft.client.options.KeyBinding("key.modularflyships.down", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_CONTROL, "category.modularflyships.main"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.player.getVehicle() == null)
                return;

            if (!(client.player.getVehicle() instanceof FlyshipEntity))
                return;

            FlyshipEntity fe = (FlyshipEntity)client.player.getVehicle();

            // @TODO: if the player is the driver
            PressedKey pk = new PressedKey(client.player.input, downKey.isPressed());
            fe.updateControls(pk);
        });
    }
    
}
