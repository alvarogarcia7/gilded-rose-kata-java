package com.gildedrose;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

    private GildedRoseApplication gildedRoseApplication;

    public MainApplication () {
        gildedRoseApplication = new GildedRoseApplication();
    }

    public static void main(String[] args) {
        new MainApplication().run(args);
    }

    private void run (final String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = readItems();
        int days = readDays(args, 2);

        gildedRoseApplication.updateQuality(items, days);
    }

    private static int readDays (final String[] args, int defaultValue) {
        if (args.length > 0) {
            return Integer.parseInt(args[0]) + 1;
        }
        return defaultValue;
    }

    private static Item[] readItems () {
        return new Item[] {
                    new Item("+5 Dexterity Vest", 10, 20), //
                    new Item("Aged Brie", 2, 0), //
                    new Item("Elixir of the Mongoose", 5, 7), //
                    new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                    new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                    new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                    // this conjured item does not work properly yet
                    new Item("Conjured Mana Cake", 3, 6) };
    }

}
