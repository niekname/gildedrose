package com.gildedrose;

public class NormalShopItem extends ShopItem {

    public NormalShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        return getSellIn().hasPassed() ? getQuality().decreaseBy(2) : getQuality().decreaseBy(1);
    }
}
