package com.gildedrose;

public class NormalShopItem implements ShopItem {

    private final Item item;

    public NormalShopItem(final Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn--;
        decreaseQuality(item);
        if (item.sellIn < 0) decreaseQuality(item);
    }
}
