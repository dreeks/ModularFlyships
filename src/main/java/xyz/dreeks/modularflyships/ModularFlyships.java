package xyz.dreeks.modularflyships;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;
import xyz.dreeks.modularflyships.model.PressedKey;

public class ModularFlyships implements ModInitializer {

	public static final String MOD_NAME = "modularflyships";

	public static final Identifier PACKET_MOVEMENT = new Identifier(MOD_NAME, "update_movement");

	public static final EntityType<Entity> MODULAR_FLYSHIP = Registry.register(
		Registry.ENTITY_TYPE,
		new Identifier(MOD_NAME, "flyship"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, FlyshipEntity::new).dimensions(EntityDimensions.fixed(4.f, 1.125f)).build()
	);

	@Override
	public void onInitialize() {
		ServerSidePacketRegistry.INSTANCE.register(PACKET_MOVEMENT, (packetContext, attachedData) -> {
			PressedKey pk = new PressedKey(attachedData);

			packetContext.getTaskQueue().execute(() -> {
				PlayerEntity ep = packetContext.getPlayer();
				if (ep.getVehicle() != null && ep.getVehicle() instanceof FlyshipEntity) {
					((FlyshipEntity)ep.getVehicle()).updateControls(pk);
				}
			});
		});	
	}

}
