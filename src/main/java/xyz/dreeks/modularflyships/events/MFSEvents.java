package xyz.dreeks.modularflyships.events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class MFSEvents {

    public static void preInit(FMLPreInitializationEvent fpie) {
        MinecraftForge.EVENT_BUS.register(new ItemEvents());
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
    }

}
