package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
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
