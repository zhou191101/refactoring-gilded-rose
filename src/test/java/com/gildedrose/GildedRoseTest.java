package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
    private Item[] items;

    @Before
    public void initItem() {
        System.out.println("OMGHAI!");

        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};
    }

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertEquals("foo", app.items[0].name);
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }

    @Test
    public void should_print_sellin_and_quality_when_day1() {
        GildedRose  app = new GildedRose(items);
        assertThat(app.items[0].sell_in, is(10));
        assertThat(app.items[0].quality, is(20));
        assertThat(app.items[1].sell_in, is(2));
        assertThat(app.items[1].quality, is(0));
        assertThat(app.items[2].sell_in, is(5));
        assertThat(app.items[2].quality, is(7));
        assertThat(app.items[3].sell_in, is(0));
        assertThat(app.items[3].quality, is(80));
        assertThat(app.items[4].sell_in, is(-1));
        assertThat(app.items[4].quality, is(80));
        assertThat(app.items[5].sell_in, is(15));
        assertThat(app.items[5].quality, is(20));
        assertThat(app.items[6].sell_in, is(10));
        assertThat(app.items[6].quality, is(49));
        assertThat(app.items[7].sell_in, is(5));
        assertThat(app.items[7].quality, is(49));
        assertThat(app.items[8].sell_in, is(1));
        assertThat(app.items[8].quality, is(20));
        assertThat(app.items[9].sell_in, is(3));
        assertThat(app.items[9].quality, is(6));

    }

    @Test
    public void should_print_sellin_and_quality_when_day2() {
        GildedRose  app = new GildedRose(items);
        app.update_quality();
        assertThat(app.items[0].sell_in, is(9));
        assertThat(app.items[0].quality, is(19));
        assertThat(app.items[1].sell_in, is(1));
        assertThat(app.items[1].quality, is(1));
        assertThat(app.items[2].sell_in, is(4));
        assertThat(app.items[2].quality, is(6));
        assertThat(app.items[3].sell_in, is(0));
        assertThat(app.items[3].quality, is(80));
        assertThat(app.items[4].sell_in, is(-1));
        assertThat(app.items[4].quality, is(80));
        assertThat(app.items[5].sell_in, is(14));
        assertThat(app.items[5].quality, is(21));
        assertThat(app.items[6].sell_in, is(9));
        assertThat(app.items[6].quality, is(50));
        assertThat(app.items[7].sell_in, is(4));
        assertThat(app.items[7].quality, is(50));
        assertThat(app.items[8].sell_in, is(0));
        assertThat(app.items[8].quality, is(23));
        assertThat(app.items[9].sell_in, is(2));
        assertThat(app.items[9].quality, is(5));

    }

    @Test
    public void should_print_sellin_and_quality_when_day3() {
        GildedRose  app = new GildedRose(items);
        app.update_quality();
        app.update_quality();
        assertThat(app.items[0].sell_in, is(8));
        assertThat(app.items[0].quality, is(18));
        assertThat(app.items[1].sell_in, is(0));
        assertThat(app.items[1].quality, is(2));
        assertThat(app.items[2].sell_in, is(3));
        assertThat(app.items[2].quality, is(5));
        assertThat(app.items[3].sell_in, is(0));
        assertThat(app.items[3].quality, is(80));
        assertThat(app.items[4].sell_in, is(-1));
        assertThat(app.items[4].quality, is(80));
        assertThat(app.items[5].sell_in, is(13));
        assertThat(app.items[5].quality, is(22));
        assertThat(app.items[6].sell_in, is(8));
        assertThat(app.items[6].quality, is(50));
        assertThat(app.items[7].sell_in, is(3));
        assertThat(app.items[7].quality, is(50));
        assertThat(app.items[8].sell_in, is(-1));
        assertThat(app.items[8].quality, is(0));
        assertThat(app.items[9].sell_in, is(1));
        assertThat(app.items[9].quality, is(4));


    }

}
