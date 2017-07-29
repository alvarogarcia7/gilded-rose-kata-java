package com.gildedrose;

import com.gildedrose.domain.BackstagePass;
import com.gildedrose.domain.Brie;
import com.gildedrose.domain.Items;
import com.gildedrose.domain.Sulfuras;

class GildedRose {
    private final Items itemsVO;
    com.gildedrose.domain.Item itemVo;
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
        this.itemsVO = new Items(items);
    }

    public void updateQuality () {
        for (int i = 0; i < items.length; i++) {
            items[i] = updateQuality(items[i]);
        }
    }

    private Item updateQuality (final Item item) {
        return createItem(item).updateQuality().toDTO();
    }

    private com.gildedrose.domain.Item createItem (final Item item) {
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

    private com.gildedrose.domain.Item toVO (final Item item) {
        return com.gildedrose.domain.Item.from(item);
    }

}
