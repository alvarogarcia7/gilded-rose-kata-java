package com.gildedrose.domain;

public class ConjuredItem extends Item {

    protected ConjuredItem (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from (final com.gildedrose.Item item) {
        return new ConjuredItem(item);
    }

    @Override
    public Item decreaseQuality () {
        super.decreaseQuality();
        super.decreaseQuality();
        return this;
    }
}
