package com.gildedrose;

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

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].getName().equals(AGED_BRIE)
                    && !items[i].getName().equals(BACKSTAGE)) {
                if (items[i].getQuality() > 0) {
                    if (!items[i].getName().equals(SULFURAS)) {
                        items[i].setQuality(items[i].getQuality() - 1);
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);
                    if (items[i].getName().equals(BACKSTAGE)) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!items[i].getName().equals(SULFURAS)) {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (!items[i].getName().equals(AGED_BRIE)) {
                    if (!items[i].getName().equals(BACKSTAGE)) {
                        if (items[i].getQuality() > 0) {
                            if (!items[i].getName().equals(SULFURAS)) {
                                items[i].setQuality(items[i].getQuality() - 1);
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}
