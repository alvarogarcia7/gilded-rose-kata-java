package com.gildedrose.domain;

import io.vavr.control.Option;

import java.util.function.Function;

public class BackstagePass extends com.gildedrose.domain.Item {
    protected BackstagePass (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from (com.gildedrose.Item value) {
        return new BackstagePass(value);
    }

    @Override
    public Item updateQuality () {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
        decreaseSellIn();
        if (isExpired()) {
            item.quality = 0;
        }
        return this;
    }

    public static Function<com.gildedrose.Item, Option<Item>> architect () {
        return (item) -> {
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                return Option.of(BackstagePass.from(item));
            }
            return Option.none();
        };
    }
}
