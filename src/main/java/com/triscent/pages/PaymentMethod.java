package com.triscent.pages;

public enum PaymentMethod {

    COD("Cash On Delivery (COD) (7.00)"), CHECK("Check / Money Order (5.00)"),
            CREDITCARD("Credit Card"), PURCHASEORDER("Purchase Order");

    private String value;

    PaymentMethod (String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
