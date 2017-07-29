package com.gildedrose.domain;

public class Item {
    private com.gildedrose.Item item;

    private Item (final com.gildedrose.Item item) {
        this.item = item;
    }

    public static Item from (final com.gildedrose.Item item) {
        return new Item(item);
    }

    public boolean isAgedBrie () {
        return item.name.equals("Aged Brie");
    }

    public boolean isASulfuras () {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public boolean isABackstagePass () {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }
}
