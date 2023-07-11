package com.gildedrose;

public abstract class ShopItem {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    
    final Item item;

    public ShopItem(final Item item) {
        this.item = item;
    }

    abstract void update();

    void decreaseSellIn() {
        item.sellIn--;
    }


    void increaseQuality() {
        item.quality = Quality.from(item.quality).increase().toInt();
    }

    void decreaseQuality() {
        item.quality = Quality.from(item.quality).decrease().toInt();
    }

    boolean sellInDateHasPassed() {
        return item.sellIn < 0;
    }
}
