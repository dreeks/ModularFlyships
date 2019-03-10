package xyz.dreeks.modularflyships.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import xyz.dreeks.modularflyships.utils.Constants;

public class MFSNetwork {
    public static final SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MOD_ID);
}
