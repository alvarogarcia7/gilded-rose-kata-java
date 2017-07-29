package com.gildedrose.domain;

public class Brie extends Item {
    private Brie (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from(com.gildedrose.Item item){
        return new Brie(item);
    }

    @Override
    public Item updateQuality () {
        increaseQuality();
        decreaseSellIn();
        if (isExpired()) {
            increaseQuality();
        }
        return this;
    }
}
