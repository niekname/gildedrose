package com.gildedrose;

class AgedBrieShopItem extends ShopItem {

    AgedBrieShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        return getSellIn().hasPassed() ? getQuality().increaseBy(2) : getQuality().increaseBy(1);
    }
}
