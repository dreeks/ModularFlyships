package xyz.dreeks.modularflyships;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.dreeks.modularflyships.entity.FlyshipEntity;
import xyz.dreeks.modularflyships.network.C2SDebugSpawnship;
import xyz.dreeks.modularflyships.network.C2SUpdateMovement;

public class ModularFlyships implements ModInitializer {

	public static final String MOD_NAME = "modularflyships";
	public static final boolean DEBUG_MODE = true;

	public static final EntityType<Entity> MODULAR_FLYSHIP = Registry.register(
		Registry.ENTITY_TYPE,
		new Identifier(MOD_NAME, "flyship"),
		FabricEntityTypeBuilder.create(SpawnGroup.MISC, FlyshipEntity::new).dimensions(EntityDimensions.fixed(4.f, 1.125f)).build()
	);

	@Override
	public void onInitialize() {
		ServerSidePacketRegistry.INSTANCE.register(C2SUpdateMovement.ID, new C2SUpdateMovement());	

		if (DEBUG_MODE) {
			ServerSidePacketRegistry.INSTANCE.register(C2SDebugSpawnship.ID, new C2SDebugSpawnship());	
		}
	}

}
