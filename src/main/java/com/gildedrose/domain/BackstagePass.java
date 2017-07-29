package com.gildedrose.domain;

public class BackstagePass extends com.gildedrose.domain.Item {
    protected BackstagePass (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from (com.gildedrose.Item value) {
        return new BackstagePass(value);
    }

    @Override
    public Item updateQuality () {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
        decreaseSellIn();
        if (isExpired()) {
            item.quality = 0;
        }
        return this;
    }
}
