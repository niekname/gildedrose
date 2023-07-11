package com.gildedrose;

class Quality {

    public static final Quality MAXIMUM = new Quality(50);
    public static final Quality MINIMUM = new Quality(0);

    private final int quality;

    private Quality(int quality) {
        this.quality = quality;
    }

    static Quality from(int quality) {
        return new Quality(quality);
    }

    Quality increaseBy(int amount) {
        var newQuality = plus(amount);
        return newQuality.hasPassedMaximumLimit() ? MAXIMUM : newQuality;
    }

    Quality decreaseBy(int amount) {
        var newQuality = minus(amount);
        return newQuality.hasPassedMinimumLimit() ? MINIMUM : newQuality;
    }

    private Quality plus(int amount) {
        return new Quality(quality + amount);
    }

    private Quality minus(int amount) {
        return new Quality(quality - amount);
    }

    private boolean hasPassedMinimumLimit() {
        return this.quality < Quality.MINIMUM.quality;
    }

    private boolean hasPassedMaximumLimit() {
        return this.quality > Quality.MAXIMUM.quality;
    }


    int toInt() {
        return quality;
    }

}
