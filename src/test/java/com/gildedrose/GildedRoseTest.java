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
        app.updateQualityAndSellIn();
        assertEquals("foo", app.getItems()[0].getName());
        assertThat(app.getItems()[0].getQuality(), is(4));
        assertThat(app.getItems()[0].getSellIn(), is(0));
    }

    @Test
    public void should_print_sellin_and_quality_when_day1() {
        GildedRose  app = new GildedRose(items);
        assertThat(app.getItems()[0].getSellIn(), is(10));
        assertThat(app.getItems()[0].getQuality(), is(20));
        assertThat(app.getItems()[1].getSellIn(), is(2));
        assertThat(app.getItems()[1].getQuality(), is(0));
        assertThat(app.getItems()[2].getSellIn(), is(5));
        assertThat(app.getItems()[2].getQuality(), is(7));
        assertThat(app.getItems()[3].getSellIn(), is(0));
        assertThat(app.getItems()[3].getQuality(), is(80));
        assertThat(app.getItems()[4].getSellIn(), is(-1));
        assertThat(app.getItems()[4].getQuality(), is(80));
        assertThat(app.getItems()[5].getSellIn(), is(15));
        assertThat(app.getItems()[5].getQuality(), is(20));
        assertThat(app.getItems()[6].getSellIn(), is(10));
        assertThat(app.getItems()[6].getQuality(), is(49));
        assertThat(app.getItems()[7].getSellIn(), is(5));
        assertThat(app.getItems()[7].getQuality(), is(49));
        assertThat(app.getItems()[8].getSellIn(), is(1));
        assertThat(app.getItems()[8].getQuality(), is(20));
        assertThat(app.getItems()[9].getSellIn(), is(3));
        assertThat(app.getItems()[9].getQuality(), is(6));

    }

    @Test
    public void should_print_sellin_and_quality_when_day2() {
        GildedRose  app = new GildedRose(items);
        app.updateQualityAndSellIn();
        assertThat(app.getItems()[0].getSellIn(), is(9));
        assertThat(app.getItems()[0].getQuality(), is(19));
        assertThat(app.getItems()[1].getSellIn(), is(1));
        assertThat(app.getItems()[1].getQuality(), is(1));
        assertThat(app.getItems()[2].getSellIn(), is(4));
        assertThat(app.getItems()[2].getQuality(), is(6));
        assertThat(app.getItems()[3].getSellIn(), is(0));
        assertThat(app.getItems()[3].getQuality(), is(80));
        assertThat(app.getItems()[4].getSellIn(), is(-1));
        assertThat(app.getItems()[4].getQuality(), is(80));
        assertThat(app.getItems()[5].getSellIn(), is(14));
        assertThat(app.getItems()[5].getQuality(), is(21));
        assertThat(app.getItems()[6].getSellIn(), is(9));
        assertThat(app.getItems()[6].getQuality(), is(50));
        assertThat(app.getItems()[7].getSellIn(), is(4));
        assertThat(app.getItems()[7].getQuality(), is(50));
        assertThat(app.getItems()[8].getSellIn(), is(0));
        assertThat(app.getItems()[8].getQuality(), is(23));
        assertThat(app.getItems()[9].getSellIn(), is(2));
        assertThat(app.getItems()[9].getQuality(), is(5));

    }

    @Test
    public void should_print_sellin_and_quality_when_day3() {
        GildedRose  app = new GildedRose(items);
        app.updateQualityAndSellIn();
        app.updateQualityAndSellIn();
        assertThat(app.getItems()[0].getSellIn(), is(8));
        assertThat(app.getItems()[0].getQuality(), is(18));
        assertThat(app.getItems()[1].getSellIn(), is(0));
        assertThat(app.getItems()[1].getQuality(), is(2));
        assertThat(app.getItems()[2].getSellIn(), is(3));
        assertThat(app.getItems()[2].getQuality(), is(5));
        assertThat(app.getItems()[3].getSellIn(), is(0));
        assertThat(app.getItems()[3].getQuality(), is(80));
        assertThat(app.getItems()[4].getSellIn(), is(-1));
        assertThat(app.getItems()[4].getQuality(), is(80));
        assertThat(app.getItems()[5].getSellIn(), is(13));
        assertThat(app.getItems()[5].getQuality(), is(22));
        assertThat(app.getItems()[6].getSellIn(), is(8));
        assertThat(app.getItems()[6].getQuality(), is(50));
        assertThat(app.getItems()[7].getSellIn(), is(3));
        assertThat(app.getItems()[7].getQuality(), is(50));
        assertThat(app.getItems()[8].getSellIn(), is(-1));
        assertThat(app.getItems()[8].getQuality(), is(0));
        assertThat(app.getItems()[9].getSellIn(), is(1));
        assertThat(app.getItems()[9].getQuality(), is(4));


    }

}
