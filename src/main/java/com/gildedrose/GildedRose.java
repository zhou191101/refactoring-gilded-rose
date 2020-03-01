package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    private Item[] items;
    private String AGED_BRIE = "Aged Brie";
    private String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public Item[] getItems() {
        return this.items;
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private boolean canChangeQuality(Item item) {
        List<String> notChangeItems = Arrays.asList(AGED_BRIE, BACKSTAGE, SULFURAS);
        return !notChangeItems.contains(item.getName()) && item.getQuality() > 0;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            if (canChangeQuality(items[i])) {
                items[i].setQuality(items[i].getQuality() - 1);
            } else {
                changeQualityWhenQualityLessThanFifty(items[i]);
            }
            changeSpecialSellIn(items[i]);

            changeQualityWhenSellInLessThanZero(items[i]);
        }
    }

    private void changeQualityWhenQualityLessThanFifty(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
            changeSpecialItemQuality(item);
        }
    }

    private void changeQualityWhenSellInLessThanZero(Item item) {
        if (item.getSellIn() < 0) {
            if (!item.getName().equals(AGED_BRIE)) {
                if (!item.getName().equals(BACKSTAGE)) {
                    if (item.getQuality() > 0 && !item.getName().equals(SULFURAS)) {
                        item.setQuality(item.getQuality() - 1);
                    }
                } else {
                    item.setQuality(0);
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private void changeSpecialSellIn(Item item) {
        if (!item.getName().equals(SULFURAS)) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    private void changeSpecialItemQuality(Item item) {
        if (item.getName().equals(BACKSTAGE)) {
            if (item.getSellIn() < 11) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }

            if (item.getSellIn() < 6) {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }
}
