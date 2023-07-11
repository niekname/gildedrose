package com.gildedrose;

public class BackstagePassesShopItem extends ShopItem {


    public BackstagePassesShopItem(final Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (item.sellIn < 5) increaseQualityBy(3);
        else if (item.sellIn < 10) increaseQualityBy(2);
        else increaseQualityBy(1);
        if (sellInDateHasPassed()) item.quality = Quality.MINIMUM.toInt();
    }
}
