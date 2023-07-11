package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items)
            .map(this::shopItemFrom)
            .forEach(ShopItem::update);
    }

    private ShopItem shopItemFrom(final Item item) {
        if (item.name.equals(AgedBrieShopItem.NAME)) return new AgedBrieShopItem(item);
        if (item.name.equals(BackstagePassesShopItem.NAME)) return new BackstagePassesShopItem(item);
        if (item.name.equals(SulfurasShopItem.NAME)) return new SulfurasShopItem(item);
        if (item.name.equals(ConjuredShopItem.NAME)) return new ConjuredShopItem(item);
        return new NormalShopItem(item);
    }
}
