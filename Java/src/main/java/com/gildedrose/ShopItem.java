package com.gildedrose;

abstract class ShopItem {

    final Item item;

    ShopItem(final Item item) {
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
