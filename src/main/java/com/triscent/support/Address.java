package com.triscent.support;

public class Address {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String country;
    private String state;
    private String city;
    private String address1;
    private String address2;
    private String postal;
    private String phoneNumber;
    private String faxNumber;


    public Address(AddressBuilder addressBuilder) {
        this.firstName = addressBuilder.firstName;
        this.lastName = addressBuilder.lastName;
        this.email = addressBuilder.email;
        this.company = addressBuilder.company;
        this.country = addressBuilder.country;
        this.state = addressBuilder.state;
        this.city = addressBuilder.city;
        this.address1 = addressBuilder.address1;
        this.address2 = addressBuilder.address2;
        this.postal = addressBuilder.postal;
        this.phoneNumber = addressBuilder.phoneNumber;
        this.faxNumber = addressBuilder.faxNumber;
    }

    public static class AddressBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private String company = "";
        private String country;
        private String state;
        private String city;
        private String address1;
        private String address2 = "";
        private String postal;
        private String phoneNumber;
        private String faxNumber="";

        public AddressBuilder(String firstName, String lastName, String email, String country, String state, String city, String address1, String postal, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.country = country;
            this.state = state;
            this.city = city;
            this.address1 = address1;
            this.postal = postal;
            this.phoneNumber = phoneNumber;
        }

        public AddressBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public AddressBuilder  setAddress2(String address2) {
            this.address2 = address2;
            return this;
        }

        public AddressBuilder  setFaxNumber(String faxNumber) {
            this.faxNumber = faxNumber;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}