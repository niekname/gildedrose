package com.gildedrose;

public class AgedBrieShopItem implements ShopItem {

    private final Item item;

    public AgedBrieShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);
        increaseQuality(item);
        if (sellInDateHasPassed(item)) increaseQuality(item);
    }
}
