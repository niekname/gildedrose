package com.gildedrose;

class AgedBrieShopItem extends ShopItem {

    public static final String NAME = "Aged Brie";

    AgedBrieShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        return getSellIn().hasPassed() ? getQuality().increaseBy(2) : getQuality().increaseBy(1);
    }
}
