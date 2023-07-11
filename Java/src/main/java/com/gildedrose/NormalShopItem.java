package com.gildedrose;

public class NormalShopItem implements ShopItem {

    private final Item item;

    public NormalShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;

        if (item.quality > 0) {
            item.quality--;
        }

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }
}
