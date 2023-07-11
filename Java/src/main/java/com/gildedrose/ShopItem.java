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
        item.sellIn = SellIn.from(item.sellIn).decrease().toInt();
    }

    boolean sellInDateHasPassed() {
        return SellIn.from(item.sellIn).hasPassed();
    }

    void increaseQualityBy(int amount) {
        item.quality = Quality.from(item.quality).increaseBy(amount).toInt();
    }

    void decreaseQualityBy(int amount) {
        item.quality = Quality.from(item.quality).decreaseBy(amount).toInt();
    }
}
