package com.gildedrose;

public interface ShopItem {

    String AGED_BRIE = "Aged Brie";
    String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    int MAXIMUM_QUALITY = 50;

    void update();

    default void decreaseSellIn(final Item item) {
        item.sellIn--;
    }

    default void increaseQuality(final Item item) {
        if (item.quality < MAXIMUM_QUALITY) item.quality++;
    }

    default void decreaseQuality(final Item item) {
        if (item.quality > 0) item.quality--;
    }

    default boolean sellInDateHasPassed(final Item item) {
        return item.sellIn < 0;
    }
}
