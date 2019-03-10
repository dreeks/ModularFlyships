package xyz.dreeks.modularflyships;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import scala.collection.immutable.Stream;
import xyz.dreeks.modularflyships.events.MFSEvents;
import xyz.dreeks.modularflyships.items.MFSItems;
import xyz.dreeks.modularflyships.proxy.IProxy;
import xyz.dreeks.modularflyships.utils.Constants;
import xyz.dreeks.modularflyships.utils.MFSConfiguration;
import xyz.dreeks.modularflyships.utils.MFSCreativeTabs;

@Mod(modid = Constants.MOD_ID, name = Constants.MOD_NAME, version = Constants.MOD_VERSION)
public class ModularFlyships
{
    @Mod.Instance
    public static ModularFlyships instance;
    public static MFSCreativeTabs tab;
    public static MFSConfiguration config;

    @SidedProxy(clientSide = Constants.PROXY_CLIENT_LOCATION, serverSide = Constants.PROXY_SERVER_LOCATION)
    public static IProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        ModularFlyships.tab = new MFSCreativeTabs();

        MFSConfiguration.preInit(event);
        MFSItems.preInit(event);
        MFSEvents.preInit(event);

        proxy.registerRenders();
        proxy.registerTileEntities();
        proxy.registerNetwork();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
