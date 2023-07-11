package com.gildedrose;

class ConjuredShopItem extends ShopItem {

    public static final String NAME = "Conjured Mana Cake";

    ConjuredShopItem(final Item item) {
        super(item);
    }

    @Override
    Quality updateQuality() {
        return getQuality().decreaseBy(2);
    }
}
