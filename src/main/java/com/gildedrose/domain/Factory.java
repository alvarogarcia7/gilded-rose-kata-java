package com.gildedrose.domain;

import com.gildedrose.*;

public class Factory {
    public Factory (final Object factory, final Object factory1, final Object factory2, final Object factory3) {
    }

    public Item build (final com.gildedrose.Item item) {
        com.gildedrose.domain.Item valueObject = com.gildedrose.domain.Item.from(item);
        if (toVO(item).isAgedBrie()) {
            valueObject = Brie.from(item);
        }
        if (toVO(item).isABackstagePass()) {
            valueObject = BackstagePass.from(item);
        }
        if (toVO(item).isASulfuras()) {
            valueObject = Sulfuras.from(item);
        }
        return valueObject;
    }

    private Item toVO (final com.gildedrose.Item item) {
        return Item.from(item);
    }

}
