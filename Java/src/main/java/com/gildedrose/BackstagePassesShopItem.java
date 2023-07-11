package com.gildedrose;

class BackstagePassesShopItem extends ShopItem {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    BackstagePassesShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        if (getSellIn().hasPassed()) return Quality.MINIMUM;
        if (getSellIn().lessThanDaysRemaining(5)) return getQuality().increaseBy(3);
        if (getSellIn().lessThanDaysRemaining(10)) return getQuality().increaseBy(2);
        return getQuality().increaseBy(1);
    }
}
