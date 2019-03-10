package xyz.dreeks.modularflyships.proxy;

public interface IProxy {

    void registerTileEntities();
    void registerRenders();
    void registerNetwork();
    boolean isClient();

}
