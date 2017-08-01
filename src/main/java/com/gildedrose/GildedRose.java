package com.gildedrose;

import com.gildedrose.domain.BackstagePass;
import com.gildedrose.domain.Brie;
import com.gildedrose.domain.ConjuredItem;
import com.gildedrose.domain.Factory;
import com.gildedrose.domain.Sulfuras;

class GildedRose {
    Item[] items;
    private Factory objectFactory;

    public GildedRose (Item[] items) {
        this.items = items;
        setObjectFactory();
    }

    private void setObjectFactory () {
        this.objectFactory = standardSetOfItems();
    }

    private Factory standardSetOfItems () {
        return new Factory(
                Brie.factory(),
                BackstagePass.factory(),
                Sulfuras.factory(),
                ConjuredItem.factory(),
                com.gildedrose.domain.Item.factory());
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
        return objectFactory.build(item);
    }
}
