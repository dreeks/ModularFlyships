package xyz.dreeks.modularflyships.network;

import net.fabricmc.fabric.api.network.PacketConsumer;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;
import xyz.dreeks.modularflyships.model.PressedKey;

public class C2SUpdateMovement implements PacketConsumer {

	public static final Identifier ID = new Identifier(ModularFlyships.MOD_NAME, "update_movement");

    @Override
    public void accept(PacketContext ctx, PacketByteBuf data) {
        PressedKey pk = new PressedKey(data);

        ctx.getTaskQueue().execute(() -> {
            PlayerEntity ep = ctx.getPlayer();
            if (ep.getVehicle() != null && ep.getVehicle() instanceof FlyshipEntity) {
                ((FlyshipEntity) ep.getVehicle()).updateControls(pk);
            }
        });
    }

}
