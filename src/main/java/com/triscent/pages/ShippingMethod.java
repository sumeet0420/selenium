package com.triscent.pages;

public enum ShippingMethod {
    GROUND("Ground (10.00)"), ONE_DAY_AIR("Next Day Air (40.00)"), TWO_DAY_AIR("2nd Day Air (20.00)");

    private String value;
    ShippingMethod(String value) {
    this.value = value;
    }

    public static void main(String[] args){
        ShippingMethod ground = ShippingMethod.GROUND;
        System.out.println(ground.value);
    }

    public String getValue(){
        return value;
    }
}
