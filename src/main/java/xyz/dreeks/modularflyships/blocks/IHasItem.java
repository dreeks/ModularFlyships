package xyz.dreeks.modularflyships.blocks;

public interface IHasItem {

    default boolean hasItem() {
        return true;
    }

}
