package com.gildedrose;

public class AgedBrieShopItem implements ShopItem {

    private final Item item;

    public AgedBrieShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;

        if (item.quality < MAXIMUM_QUALITY) {
            item.quality++;
        }


        if (item.sellIn < 0) {
            if (item.quality < MAXIMUM_QUALITY) {
                item.quality++;
            }
        }
    }
}
