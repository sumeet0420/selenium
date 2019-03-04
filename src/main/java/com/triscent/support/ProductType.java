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
/*
package com.triscent.support;

public interface ProductType {

    String BOOKS = "BOOKS";
    String APPARELS = "APPAREL & SHOES";
    String DIGITAL_DOWNLOADS = "DIGITAL DOWNLOADS";
    String JEWELRY = "JEWELRY";
    String GIFT_CARDS = "GIFT_CARDS";

    public interface COMPUTERS {

        String DESKTOPS = "Desktop";
        String NOTEBOOK = "Notebooks";
        String ACCESSORIES = "Accessories";
    }z

    public interface ELECTONICS {
        String CAMERA = "Camera, Photo";
        String CELL_PHONES = "Cell phones";
    }

}
*/
