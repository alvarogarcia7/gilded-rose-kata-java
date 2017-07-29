package com.gildedrose;

import com.gildedrose.domain.BackstagePass;
import com.gildedrose.domain.Brie;
import com.gildedrose.domain.Items;

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
        if (toVO(item).isAgedBrie()) {
            return updateQualityToAgedBrie(item);
        }
        if (toVO(item).isABackstagePass()) {
            return BackstagePass.from(item).updateQuality().toDTO();
        }
        if (toVO(item).isASulfuras()) {
            return item;
        }
        decreaseQuality(item);
        decreaseSellIn(item);
        if (toVO(item).isExpired()) {
            decreaseQuality(item);
        }
        return item;
    }

    private Item updateQualityToAgedBrie (final Item item) {
        return Brie.from(item).updateQuality().toDTO();
    }

    private Item decreaseQuality (final Item item) {
        return toVO(item).decreaseQuality().toDTO();
    }

    private Item decreaseSellIn (final Item item) {
        return toVO(item).decreaseSellIn().toDTO();
    }

    private Item increaseQuality (final Item item) {
        return toVO(item).increaseQuality().toDTO();
    }

    private com.gildedrose.domain.Item toVO (final Item item) {
        return com.gildedrose.domain.Item.from(item);
    }

}
