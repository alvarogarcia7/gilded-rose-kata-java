package com.gildedrose.domain;

public class Item {
    protected com.gildedrose.Item item;

    protected Item (final com.gildedrose.Item item) {
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

    public boolean isExpired () {
        return item.sellIn < 0;
    }

    public Item decreaseSellIn () {
        item.sellIn = item.sellIn - 1;
        return this;
    }

    public Item increaseQuality () {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
        return this;
    }

    public com.gildedrose.Item toDTO () {
        return item;
    }

    public Item decreaseQuality () {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        return this;
    }

    public Item updateQuality () {
        decreaseQuality();
        decreaseSellIn();
        if (isExpired()) {
            decreaseQuality();
        }
        return this;
    }
}
