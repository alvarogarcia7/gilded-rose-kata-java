package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

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

    public static Function<com.gildedrose.Item, Option<Item>> factory () {
        return (item) -> {
            if (Item.from(item).isAgedBrie()) {
                return Option.of(Brie.from(item));
            }
            return Option.none();
        };
    }
}
