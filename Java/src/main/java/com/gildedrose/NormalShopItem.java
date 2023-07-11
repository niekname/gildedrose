package com.gildedrose;

public class NormalShopItem extends ShopItem {


    public NormalShopItem(final Item item) {
        super(item);
    }

    @Override
    public void update() {
        decreaseSellIn();
        decreaseQuality();
        if (sellInDateHasPassed()) decreaseQuality();
    }
}
