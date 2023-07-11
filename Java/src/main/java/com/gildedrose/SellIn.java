package com.gildedrose;

public class SellIn {

    private final int sellIn;

    private SellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    static SellIn from(int sellIn) {
        return new SellIn(sellIn);
    }

    SellIn decrease() {
        return new SellIn(sellIn - 1);
    }

    boolean hasPassed() {
        return sellIn < 0;
    }

    int toInt() {
        return sellIn;
    }

}
