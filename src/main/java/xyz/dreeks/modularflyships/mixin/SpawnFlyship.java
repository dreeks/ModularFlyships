package xyz.dreeks.modularflyships.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.Vec3d;
import xyz.dreeks.modularflyships.ModularFlyships;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;

@Mixin(ClientPlayNetworkHandler.class)
public class SpawnFlyship {

    @Shadow
    private ClientWorld world;

    // https://gist.github.com/matjojo/011bbd340a71f258e25806bf1c82229c
    @Inject(
			method = "onEntitySpawn(Lnet/minecraft/network/packet/s2c/play/EntitySpawnS2CPacket;)V",
			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/network/packet/s2c/play/EntitySpawnS2CPacket;getEntityTypeId()Lnet/minecraft/entity/EntityType;"),
			cancellable = true,
			locals = LocalCapture.CAPTURE_FAILHARD
	)
	private void onEntitySpawn(EntitySpawnS2CPacket packet, CallbackInfo ci, double x, double y, double z, EntityType<?> type) {
        Entity entity = null;

		if (type == ModularFlyships.MODULAR_FLYSHIP) {
            entity = new FlyshipEntity(world, x, y, z);
        }

		if (entity != null) {
			int entityId = packet.getId();
			entity.setVelocity(Vec3d.ZERO);
			entity.updatePosition(x, y, z);
			entity.updateTrackedPosition(x, y, z);
			entity.pitch = (float) (packet.getPitch() * 360) / 256.0F;
			entity.yaw = (float) (packet.getYaw() * 360) / 256.0F;
			entity.setEntityId(entityId);
			entity.setUuid(packet.getUuid());
			this.world.addEntity(entityId, entity);
			ci.cancel();
		}
	}

}
