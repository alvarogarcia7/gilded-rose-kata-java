package com.gildedrose;

public class GildedRoseApplication {
    public void updateQuality (final Item[] items, final int days) {
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }
}
