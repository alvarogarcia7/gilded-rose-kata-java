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

    public static Function<com.gildedrose.Item, Option<Item>> architect () {
        return (item) -> {
            if (item.name.equals("Aged Brie")) {
                return Option.of(Brie.from(item));
            }
            return Option.none();
        };
    }
}
