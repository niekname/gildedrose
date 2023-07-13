package com.gildedrose;

class SulfurasShopItem extends ShopItem {

    SulfurasShopItem(final Item item) {
        super(item);
    }

    @Override
    SellIn updateSellIn() {
        return getSellIn();
    }

    @Override
    Quality updateQuality() {
        return getQuality();
    }
}
