package xyz.dreeks.modularflyships.client.keybinds;

import org.lwjgl.glfw.GLFW;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;
import xyz.dreeks.modularflyships.model.PressedKey;
import xyz.dreeks.modularflyships.network.C2SDebugSpawnship;

@Environment(EnvType.CLIENT)
public class MFSKeybinds {

    public static KeyBinding downKey;
    public static KeyBinding debugSpawnShip;
    private static int debugToProcess = 0;

    public static void initialize() {
        downKey = KeyBindingHelper.registerKeyBinding(new net.minecraft.client.options.KeyBinding("key.modularflyships.down", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_CONTROL, "category.modularflyships.main"));

        if (ModularFlyships.DEBUG_MODE) {
            debugSpawnShip = KeyBindingHelper.registerKeyBinding(new net.minecraft.client.options.KeyBinding("key.modularflyships.debug.spawn", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, "category.modularflyships.main"));
        }


        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (ModularFlyships.DEBUG_MODE) {
                if (debugToProcess == 0 && debugSpawnShip.isPressed()) {
                    debugToProcess = 1;
                }

                if (debugToProcess == 2 && !debugSpawnShip.isPressed()) {
                    debugToProcess = 0;
                }

                if (debugToProcess == 1) {
                    ClientSidePacketRegistry.INSTANCE.sendToServer(C2SDebugSpawnship.ID, new PacketByteBuf(Unpooled.buffer()));
                    debugToProcess = 2;
                }
            }

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
