package xyz.dreeks.modularflyships.utils;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class MFSConfiguration {

    public static void preInit(FMLPreInitializationEvent evt){
        Configuration cfg = new Configuration(evt.getSuggestedConfigurationFile());

        /**
         * Config loading
         */

        if (cfg.hasChanged()){
            cfg.save();
        }
    }

}
