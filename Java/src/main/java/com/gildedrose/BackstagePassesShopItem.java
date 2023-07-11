package com.gildedrose;

public class BackstagePassesShopItem implements ShopItem {

    private final Item item;

    public BackstagePassesShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }


        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }
}
