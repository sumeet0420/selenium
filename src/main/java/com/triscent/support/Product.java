package com.triscent.support;

public class Product {

    private String productName;
    private String price;
    private int quantity;
    private ProductType productType;

    public Product(String productName, String price, int quantity, ProductType productType) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
    }

}
