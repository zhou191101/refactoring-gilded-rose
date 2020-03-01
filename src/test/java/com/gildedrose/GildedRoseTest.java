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
        assertEquals("foo", app.getItems()[0].name);
        assertThat(app.getItems()[0].quality, is(4));
        assertThat(app.getItems()[0].sellIn, is(0));
    }

    @Test
    public void should_print_sellin_and_quality_when_day1() {
        GildedRose  app = new GildedRose(items);
        assertThat(app.getItems()[0].sellIn, is(10));
        assertThat(app.getItems()[0].quality, is(20));
        assertThat(app.getItems()[1].sellIn, is(2));
        assertThat(app.getItems()[1].quality, is(0));
        assertThat(app.getItems()[2].sellIn, is(5));
        assertThat(app.getItems()[2].quality, is(7));
        assertThat(app.getItems()[3].sellIn, is(0));
        assertThat(app.getItems()[3].quality, is(80));
        assertThat(app.getItems()[4].sellIn, is(-1));
        assertThat(app.getItems()[4].quality, is(80));
        assertThat(app.getItems()[5].sellIn, is(15));
        assertThat(app.getItems()[5].quality, is(20));
        assertThat(app.getItems()[6].sellIn, is(10));
        assertThat(app.getItems()[6].quality, is(49));
        assertThat(app.getItems()[7].sellIn, is(5));
        assertThat(app.getItems()[7].quality, is(49));
        assertThat(app.getItems()[8].sellIn, is(1));
        assertThat(app.getItems()[8].quality, is(20));
        assertThat(app.getItems()[9].sellIn, is(3));
        assertThat(app.getItems()[9].quality, is(6));

    }

    @Test
    public void should_print_sellin_and_quality_when_day2() {
        GildedRose  app = new GildedRose(items);
        app.update_quality();
        assertThat(app.getItems()[0].sellIn, is(9));
        assertThat(app.getItems()[0].quality, is(19));
        assertThat(app.getItems()[1].sellIn, is(1));
        assertThat(app.getItems()[1].quality, is(1));
        assertThat(app.getItems()[2].sellIn, is(4));
        assertThat(app.getItems()[2].quality, is(6));
        assertThat(app.getItems()[3].sellIn, is(0));
        assertThat(app.getItems()[3].quality, is(80));
        assertThat(app.getItems()[4].sellIn, is(-1));
        assertThat(app.getItems()[4].quality, is(80));
        assertThat(app.getItems()[5].sellIn, is(14));
        assertThat(app.getItems()[5].quality, is(21));
        assertThat(app.getItems()[6].sellIn, is(9));
        assertThat(app.getItems()[6].quality, is(50));
        assertThat(app.getItems()[7].sellIn, is(4));
        assertThat(app.getItems()[7].quality, is(50));
        assertThat(app.getItems()[8].sellIn, is(0));
        assertThat(app.getItems()[8].quality, is(23));
        assertThat(app.getItems()[9].sellIn, is(2));
        assertThat(app.getItems()[9].quality, is(5));

    }

    @Test
    public void should_print_sellin_and_quality_when_day3() {
        GildedRose  app = new GildedRose(items);
        app.update_quality();
        app.update_quality();
        assertThat(app.getItems()[0].sellIn, is(8));
        assertThat(app.getItems()[0].quality, is(18));
        assertThat(app.getItems()[1].sellIn, is(0));
        assertThat(app.getItems()[1].quality, is(2));
        assertThat(app.getItems()[2].sellIn, is(3));
        assertThat(app.getItems()[2].quality, is(5));
        assertThat(app.getItems()[3].sellIn, is(0));
        assertThat(app.getItems()[3].quality, is(80));
        assertThat(app.getItems()[4].sellIn, is(-1));
        assertThat(app.getItems()[4].quality, is(80));
        assertThat(app.getItems()[5].sellIn, is(13));
        assertThat(app.getItems()[5].quality, is(22));
        assertThat(app.getItems()[6].sellIn, is(8));
        assertThat(app.getItems()[6].quality, is(50));
        assertThat(app.getItems()[7].sellIn, is(3));
        assertThat(app.getItems()[7].quality, is(50));
        assertThat(app.getItems()[8].sellIn, is(-1));
        assertThat(app.getItems()[8].quality, is(0));
        assertThat(app.getItems()[9].sellIn, is(1));
        assertThat(app.getItems()[9].quality, is(4));


    }

}
