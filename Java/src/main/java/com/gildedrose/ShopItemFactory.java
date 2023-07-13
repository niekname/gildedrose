package com.gildedrose;

public class ShopItemFactory {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String SULFURAS = "Sulfuras";
    public static final String CONJURED = "Conjured";

    static ShopItem shopItemFrom(final Item item) {
        if (is(item, AGED_BRIE)) return new AgedBrieShopItem(item);
        if (is(item, BACKSTAGE_PASSES)) return new BackstagePassesShopItem(item);
        if (is(item, SULFURAS)) return new SulfurasShopItem(item);
        if (is(item, CONJURED)) return new ConjuredShopItem(item);
        return new NormalShopItem(item);
    }

    private static boolean is(Item item, String descriminator) {
        return item.name.contains(descriminator);
    }
}
