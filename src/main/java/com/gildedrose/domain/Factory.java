package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

public class Factory {
    private final Function<com.gildedrose.Item, Option<Item>>[] factories;

    public Factory (final Function<com.gildedrose.Item, Option<Item>>... factories) {
        this.factories = factories;
    }

    public Item build (final com.gildedrose.Item item) {
        for (final Function<com.gildedrose.Item, Option<Item>> factory : factories) {
            Option<Item> apply = factory.apply(item);
            if (apply.isDefined()) {
                return apply.get();
            }
        }
        throw new RuntimeException("This item does not match any of the previous rules");
    }
}
