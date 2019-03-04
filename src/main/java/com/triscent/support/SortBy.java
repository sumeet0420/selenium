package com.triscent.support;

public enum SortBy {
     orderByNameAscending("Name: A to Z"), orderByNameDescending("Name: Z to A"), position("Position"),
    priceByAscending("Price: Low to High"), priceByDescending("Price: High to Low"), createdOn("Created on");

    private String value;

    SortBy(String value){
         this.value = value;
    }

    public String getValue() {
        return value;
    }
}

