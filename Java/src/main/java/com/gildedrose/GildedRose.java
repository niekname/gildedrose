package com.gildedrose;

import java.util.Arrays;

import static com.gildedrose.ShopItem.AGED_BRIE;
import static com.gildedrose.ShopItem.BACKSTAGE_PASSES;
import static com.gildedrose.ShopItem.SULFURAS_HAND_OF_RAGNAROS;

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
        if (item.name.equals(AGED_BRIE)) return new AgedBrieShopItem(item);
        if (item.name.equals(BACKSTAGE_PASSES)) return new BackstagePassesShopItem(item);
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) return new SulfurasShopItem(item);
        return new NormalShopItem(item);
    }
}
