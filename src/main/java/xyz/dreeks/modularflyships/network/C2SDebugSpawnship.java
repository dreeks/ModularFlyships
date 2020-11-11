package xyz.dreeks.modularflyships.network;

import net.fabricmc.fabric.api.network.PacketConsumer;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

public class C2SDebugSpawnship implements PacketConsumer {

	public static final Identifier ID = new Identifier(ModularFlyships.MOD_NAME, "spawn_ship");

    @Override
    public void accept(PacketContext ctx, PacketByteBuf data) {
        ctx.getTaskQueue().execute(() -> {
            PlayerEntity ep = ctx.getPlayer();
            BlockPos pos = ep.getBlockPos().add(0, 2, 0);

            ep.world.spawnEntity(new FlyshipEntity(ep.world, pos.getX(), pos.getY(), pos.getZ()));
        });
    }

}
