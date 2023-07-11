package com.gildedrose;

public class NormalShopItem extends ShopItem {


    public NormalShopItem(final Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        if (sellInDateHasPassed()) decreaseQualityBy(2);
        else decreaseQualityBy(1);
    }
}
