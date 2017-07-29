package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose (Item[] items) {
        this.items = items;
    }

    public void updateQuality () {
        for (int i = 0; i < items.length; i++) {
            if (!isAgedBrie(items[i]) && !isABackstagePass(items[i])) {
                if (!isASulfuras(items[i])) {
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                increaseQuality(items[i]);
                if (isABackstagePass(items[i])) {
                    if (items[i].sellIn < 11) {
                        increaseQuality(items[i]);
                    }

                    if (items[i].sellIn < 6) {
                        increaseQuality(items[i]);
                    }
                }
            }

            if (!isASulfuras(items[i])) {
                decreaseSellIn(i);
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(items[i])) {
                    if (!isABackstagePass(items[i])) {
                        if (items[i].quality > 0) {
                            if (!isASulfuras(items[i])) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    increaseQuality(items[i]);
                }
            }
        }
    }

    private boolean isAgedBrie (final Item item) {
        return item.name.equals("Aged Brie");
    }

    private void decreaseSellIn (final int i) {
        items[i].sellIn = items[i].sellIn - 1;
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
