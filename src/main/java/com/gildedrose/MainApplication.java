package com.gildedrose;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class MainApplication {

    private GildedRoseApplication gildedRoseApplication;

    public MainApplication () {
        gildedRoseApplication = new GildedRoseApplication();
    }

    public static void main (String[] args) {
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

    private Item[] readItems () {
        final Scanner scanner = new Scanner(System.in);
        final ArrayList<Item> items = new ArrayList<>();
        final List<String> lines = new ArrayList<>();
        while(scanner.hasNext()) {
            final String line = scanner.nextLine();
            lines.add(line);
        }
        for (String line : lines) {
            items.add(createItem(line));
        }
        return toArray(items);
    }

    private Item[] toArray (final ArrayList<Item> items) {
        return items.toArray(new Item[0]);
    }

    private Item createItem (final String line) {
        final String[] parts = line.split(";");
        final String name = parts[0];
        final int sellIn = Integer.parseInt(parts[1]);
        final int quality = Integer.parseInt(parts[2]);
        return new Item(name, sellIn, quality);
    }

}
