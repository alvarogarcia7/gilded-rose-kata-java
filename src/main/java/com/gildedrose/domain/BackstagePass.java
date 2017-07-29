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

    public static Function<com.gildedrose.Item, Option<Item>> factory () {
        return (item) -> {
            if (BackstagePass.from(item).isABackstagePass()) {
                return Option.of(BackstagePass.from(item));
            }
            return Option.none();
        };
    }
}
