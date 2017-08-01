package com.gildedrose;

import com.gildedrose.domain.ItemProductionCenter;

class GildedRose {
    Item[] items;
    private ItemProductionCenter itemProductionCenter;

    public GildedRose (Item[] items) {
        this.items = items;
        setItemProductionCenter(ItemProductionCenter.standardSetOfItems());
    }

    public void setItemProductionCenter (final ItemProductionCenter itemProductionCenter) {
        this.itemProductionCenter = itemProductionCenter;
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
        return itemProductionCenter.build(item);
    }
}
