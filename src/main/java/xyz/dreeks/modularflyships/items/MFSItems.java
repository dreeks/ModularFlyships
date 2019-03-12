package xyz.dreeks.modularflyships.items;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

public class MFSItems {

    public static ArrayList<ItemBase> items = new ArrayList<>();

    public static ItemFlyship flyship;

    public static void preInit(FMLPreInitializationEvent fpie) {

        /**
         * Initialize items
         */

        items.add(flyship = new ItemFlyship());

    }

}
