package com.gildedrose;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.SULFURAS_HAND_OF_RAGNAROS;

public class AgedBrieShopItem implements ShopItem {

    private final Item item;

    public AgedBrieShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.name.equals(AGED_BRIE)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
