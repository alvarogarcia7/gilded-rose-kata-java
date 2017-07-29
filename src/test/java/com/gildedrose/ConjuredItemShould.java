package com.gildedrose;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;

public class ConjuredItemShould_Degrade_twice_as_fast_as_normal_items {

    @Test
    public void while_before_the_sellIn_date () {
        Item conjured = new Item("conjured", 8, 9);
        MatcherAssert.assertThat(ConjuredItem.from(conjured).updateQuality().toDTO(), is(new Item("conjured", 7, 7)));
    }


    @Test
    public void while_after_the_sellIn_date () {
        Item conjured = new Item("conjured", 8, 9);
        MatcherAssert.assertThat(ConjuredItem.from(conjured).updateQuality().toDTO(), is(new Item("conjured", 7,
                5)));
    }
}
