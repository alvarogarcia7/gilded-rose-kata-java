package com.gildedrose.domain;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private final List<Item> values;

    public Items (final com.gildedrose.Item... dtos) {
        values = new ArrayList<>();
        for (final com.gildedrose.Item dto : dtos) {
            Item valueObject = Item.from(dto);
            values.add(valueObject);
        }
    }
}
