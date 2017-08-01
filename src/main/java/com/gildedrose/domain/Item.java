package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

public class Item {
    protected com.gildedrose.Item item;

    protected Item (final com.gildedrose.Item item) {
        this.item = item;
    }

    public static Item from (final com.gildedrose.Item item) {
        return new Item(item);
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

    public static Function<com.gildedrose.Item, Option<Item>> architect (){
        return (item1 -> Option.of(Item.from(item1)));
    }

    @Override
    public boolean equals (final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Item item1 = (Item) o;

        return item != null ? item.equals(item1.item) : item1.item == null;
    }

    @Override
    public int hashCode () {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public String toString () {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("item=").append(item);
        sb.append('}');
        return sb.toString();
    }
}
