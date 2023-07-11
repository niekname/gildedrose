package com.gildedrose;

public abstract class ShopItem {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    final Item item;

    public ShopItem(final Item item) {
        this.item = item;
    }

    void update() {
        item.sellIn = updateSellIn().toInt();
        item.quality = updateQuality().toInt();
    }

    SellIn updateSellIn() {
        return getSellIn().decrease();
    }

    abstract Quality updateQuality();

    SellIn getSellIn() {
        return SellIn.from(item.sellIn);
    }

    Quality getQuality() {
        return Quality.from(item.quality);
    }

}
