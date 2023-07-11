package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    @Test
    void normalItem_shouldDecreaseSellIn() {
        Item item = new Item("normal item", 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
    }

    @Test
    void normalItem_shouldDecreaseQuality() {
        Item item = new Item("normal item", 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void normalItem_qualityDegradesTwiceAsFastOnceSellInDateHasPassed() {
        Item item = new Item("normal item", 0, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    void normalItem_qualityIsNeverNegative() {
        Item item = new Item("normal item", 3, 0);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void agedBrie_shouldDecreaseSellIn() {
        Item item = new Item(AgedBrieShopItem.NAME, 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
    }

    @Test
    void agedBrie_increasesInQualityTheOlderItGets() {
        Item item = new Item(AgedBrieShopItem.NAME, 3, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void agedBrie_increasesInQualityBy2onceSellInDateHasPassed() {
        Item item = new Item(AgedBrieShopItem.NAME, -1, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void agedBrie_qualityIsNeverMoreThan50() {
        Item item = new Item(AgedBrieShopItem.NAME, 3, 50);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void agedBrie_qualityIsNeverMoreThan50evenWhenIncreasingFast() {
        Item item = new Item(AgedBrieShopItem.NAME, 0, 49);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }


    @Test
    void sulfuras_neverDecreases() {
        Item item = new Item(SulfurasShopItem.NAME, 3, 56);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(3);
        assertThat(item.quality).isEqualTo(56);
    }

    @Test
    void backstagePasses_shouldDecreaseSellIn() {
        Item item = new Item(BackstagePassesShopItem.NAME, 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
    }

    @Test
    void backstagePasses_increasesInQualityTheOlderItGets() {
        Item item = new Item(BackstagePassesShopItem.NAME, 15, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void backstagePasses_increasesInQualityBy2WhenThereAre10daysOrLess() {
        Item item = new Item(BackstagePassesShopItem.NAME, 10, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void backstagePasses_increasesInQualityBy3WhenThereAre5daysOrLess() {
        Item item = new Item(BackstagePassesShopItem.NAME, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void backstagePasses_qualityDropsTo0AfterTheConcert() {
        Item item = new Item(BackstagePassesShopItem.NAME, 0, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void backstagePasses_qualityIsNeverMoreThan50() {
        Item item = new Item(BackstagePassesShopItem.NAME, 3, 50);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    private GildedRose createGildedRose(Item item) {
        return new GildedRose(new Item[]{item});
    }
}
