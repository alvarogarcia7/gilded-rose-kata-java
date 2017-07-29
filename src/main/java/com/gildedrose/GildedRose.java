package com.gildedrose;

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
            increaseQuality(item);
            decreaseSellIn(item);
            if (toVO(item).isExpired()) {
                increaseQuality(item);
            }
            return item;
        }
        if (toVO(item).isABackstagePass()) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
            decreaseSellIn(item);
            if (toVO(item).isExpired()) {
                item.quality = 0;
            }
            return item;
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

    private void decreaseQuality (final Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellIn (final Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality (final Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private com.gildedrose.domain.Item toVO (final Item item) {
        return com.gildedrose.domain.Item.from(item);
    }

}
