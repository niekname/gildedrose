package com.gildedrose;

public class SulfurasShopItem extends ShopItem {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

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
