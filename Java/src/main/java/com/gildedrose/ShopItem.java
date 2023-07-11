package com.gildedrose;

public abstract class ShopItem {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public static final int MAXIMUM_QUALITY = 50;
    public static final int MINIMUM_QUALITY = 0;

    final Item item;

    public ShopItem(final Item item) {
        this.item = item;
    }

    abstract void update();

    void decreaseSellIn() {
        item.sellIn--;
    }

    void increaseQuality() {
        if (item.quality < MAXIMUM_QUALITY) item.quality++;
    }

    void decreaseQuality() {
        if (item.quality > MINIMUM_QUALITY) item.quality--;
    }

    boolean sellInDateHasPassed() {
        return item.sellIn < 0;
    }
}
