package com.gildedrose;

class ConjuredShopItem extends ShopItem {

    ConjuredShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        return getQuality().decreaseBy(2);
    }
}
