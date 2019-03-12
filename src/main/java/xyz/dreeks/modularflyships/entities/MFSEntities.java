package xyz.dreeks.modularflyships.entities;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import xyz.dreeks.modularflyships.utils.Constants;

import java.util.ArrayList;

public class MFSEntities {

    public static ArrayList<EntityEntry> entities = new ArrayList<>();

    public static void preInit(FMLPreInitializationEvent fpie) {

        entities.add(EntityEntryBuilder.create()
                .entity(EntityFlyshipBase.class)
                .id(new ResourceLocation(Constants.MOD_ID, "flyship_base"), 40)
                .name("flyship_base")
                .tracker(64, 20, false)
                .build()
        );

    }

}
