package com.gildedrose;

public class BackstagePassesShopItem extends ShopItem {

    public BackstagePassesShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        if (getSellIn().hasPassed()) return Quality.MINIMUM;
        if (getSellIn().toInt() < 5) return getQuality().increaseBy(3);
        if (getSellIn().toInt() < 10) return getQuality().increaseBy(2);
        return getQuality().increaseBy(1);
    }
}
