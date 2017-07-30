package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

public class ConjuredItem extends Item {

    protected ConjuredItem (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from (final com.gildedrose.Item item) {
        return new ConjuredItem(item);
    }

    public static Function<com.gildedrose.Item, Option<Item>> factory(){
        return (item1 -> {
            if(item1.name.contains("Conjured")){
                return Option.of(ConjuredItem.from(item1));
            }
            return Option.none();
        });
    }

    @Override
    public Item decreaseQuality () {
        super.decreaseQuality();
        super.decreaseQuality();
        return this;
    }
}
