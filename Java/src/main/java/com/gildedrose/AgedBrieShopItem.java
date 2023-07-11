package com.gildedrose;

public class AgedBrieShopItem extends ShopItem {


    public AgedBrieShopItem(final Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (sellInDateHasPassed()) increaseQualityBy(2);
        else increaseQualityBy(1);
    }
}
