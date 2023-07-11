package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.GildedRose.AGED_BRIE;
import static com.gildedrose.GildedRose.BACKSTAGE_PASSES;
import static com.gildedrose.GildedRose.SULFURAS_HAND_OF_RAGNAROS;
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
        Item item = new Item(AGED_BRIE, 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
    }

    @Test
    void agedBrie_increasesInQualityTheOlderItGets() {
        Item item = new Item(AGED_BRIE, 3, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void agedBrie_increasesInQualityBy2onceSellInDateHasPassed() {
        Item item = new Item(AGED_BRIE, -1, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void agedBrie_qualityIsNeverMoreThan50() {
        Item item = new Item(AGED_BRIE, 3, 50);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void sulfuras_neverDecreases() {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS, 3, 56);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(3);
        assertThat(item.quality).isEqualTo(56);
    }

    @Test
    void backstagePasses_shouldDecreaseSellIn() {
        Item item = new Item(BACKSTAGE_PASSES, 3, 7);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.sellIn).isEqualTo(2);
    }

    @Test
    void backstagePasses_increasesInQualityTheOlderItGets() {
        Item item = new Item(BACKSTAGE_PASSES, 15, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    void backstagePasses_increasesInQualityBy2WhenThereAre10daysOrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 10, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void backstagePasses_increasesInQualityBy3WhenThereAre5daysOrLess() {
        Item item = new Item(BACKSTAGE_PASSES, 5, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void backstagePasses_qualityDropsTo0AfterTheConcert() {
        Item item = new Item(BACKSTAGE_PASSES, 0, 5);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    void backstagePasses_qualityIsNeverMoreThan50() {
        Item item = new Item(BACKSTAGE_PASSES, 3, 50);
        GildedRose app = createGildedRose(item);
        app.updateQuality();

        assertThat(item.quality).isEqualTo(50);
    }

    private GildedRose createGildedRose(Item item) {
        return new GildedRose(new Item[]{item});
    }
}
