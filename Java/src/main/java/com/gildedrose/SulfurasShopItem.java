package com.gildedrose;

public class SulfurasShopItem extends ShopItem {


    public SulfurasShopItem(final Item item) {
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
