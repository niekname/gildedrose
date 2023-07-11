package com.gildedrose;

public class BackstagePassesShopItem extends ShopItem {


    public BackstagePassesShopItem(final Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();
        if (item.sellIn < 10) increaseQuality();
        if (item.sellIn < 5) increaseQuality();
        if (sellInDateHasPassed()) item.quality = Quality.MINIMUM.toInt();
    }
}
