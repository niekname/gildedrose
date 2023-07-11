package com.gildedrose;

public class BackstagePassesShopItem implements ShopItem {

    private final Item item;

    public BackstagePassesShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality++;

            if (item.sellIn < 11) {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < MAXIMUM_QUALITY) {
                    item.quality++;
                }
            }
        }


        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
