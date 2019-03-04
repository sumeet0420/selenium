package com.triscent.support;

public enum ProductType {
    BOOKS("BOOKS"), COMPUTERS("COMPUTERS"), ELECTONICS("ELECTONICS"),
    APPARELS("APPAREL & SHOES"),
    DIGITAL_DOWNLOADS("DIGITAL DOWNLOADS"), JEWELRY("JEWELRY"),
    GIFT_CARDS("GIFT_CARDS");

    public final String category;

    ProductType(String category) {
        this.category = category;
    }


}
