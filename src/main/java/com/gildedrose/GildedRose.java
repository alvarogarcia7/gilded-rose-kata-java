package com.gildedrose;

import com.gildedrose.domain.Factory;

class GildedRose {
    Item[] items;
    private Factory objectFactory;

    public GildedRose (Item[] items) {
        this.items = items;
        setObjectFactory(Factory.standardSetOfItems());
    }

    private void setObjectFactory (final Factory factory) {
        this.objectFactory = factory;
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
