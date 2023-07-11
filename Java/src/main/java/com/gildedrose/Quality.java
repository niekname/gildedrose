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

    Quality increase() {
        var newQuality = Quality.from(quality + 1);
        return newQuality.hasPassedMaximumLimit() ? MAXIMUM : newQuality;
    }

    Quality decrease() {
        var newQuality = Quality.from(quality - 1);
        return newQuality.hasPassedMinimumLimit() ? MINIMUM : newQuality;
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
