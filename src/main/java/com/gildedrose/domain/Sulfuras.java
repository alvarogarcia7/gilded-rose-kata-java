package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

public class Sulfuras extends Item {
    protected Sulfuras (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from(com.gildedrose.Item value){
        return new Sulfuras(value);
    }

    @Override
    public Item updateQuality () {
        //Null-object pattern
        return this;
    }

    public static Function<com.gildedrose.Item, Option<Item>> architect () {
        return (item) -> {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return Option.of(Sulfuras.from(item));
            }
            return Option.none();
        };
    }
}
