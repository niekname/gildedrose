package com.gildedrose;

public class BackstagePassesShopItem implements ShopItem {

    private final Item item;

    public BackstagePassesShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        decreaseSellIn(item);
        increaseQuality(item);
        if (item.sellIn < 10) increaseQuality(item);
        if (item.sellIn < 5) increaseQuality(item);
        if (sellInDateHasPassed(item)) item.quality = 0;
    }
}
