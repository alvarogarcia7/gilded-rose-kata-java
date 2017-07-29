package com.gildedrose;

class GildedRose {
    private final Items itemsVO;
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
        this.itemsVO = new Items(items);
    }

    public void updateQuality () {
        for (int i = 0; i < items.length; i++) {
            updateQuality(items[i]);
        }
    }

    private void updateQuality (final Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else if (isABackstagePass(item)) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else if (!isASulfuras(item)) {
            decreaseQuality(item);
        }

        if (!isASulfuras(item)) {
            decreaseSellIn(item);
        }

        if (isExpired(item)) {
            if (isAgedBrie(item)) {
                increaseQuality(item);
            } else {
                if (isABackstagePass(item)) {
                    item.quality = 0;
                } else if (!isASulfuras(item)) {
                    decreaseQuality(item);
                }
            }
        }
    }

    private boolean isExpired (final Item item) {
        return item.sellIn < 0;
    }

    private void decreaseQuality (final Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private boolean isAgedBrie (final Item item) {
        return item.name.equals("Aged Brie");
    }

    private void decreaseSellIn (final Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQuality (final Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private boolean isASulfuras (final Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isABackstagePass (final Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

}
