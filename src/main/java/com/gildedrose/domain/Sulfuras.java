package com.gildedrose.domain;

public class Sulfuras extends Item {
    protected Sulfuras (final com.gildedrose.Item item) {
        super(item);
    }

    public static Item from(com.gildedrose.Item value){
        return new Sulfuras(value);
    }

    @Override
    public Item updateQuality () {
        //Null-object pattern
        return this;
    }
}
