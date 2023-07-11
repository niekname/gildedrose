package com.gildedrose;

public class BackstagePassesShopItem implements ShopItem {

    private final Item item;

    public BackstagePassesShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;

        if (item.quality < MAXIMUM_QUALITY) {
            item.quality++;

            if (item.sellIn < 10) {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;
                }
            }

            if (item.sellIn < 5) {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;
                }
            }
        }

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
