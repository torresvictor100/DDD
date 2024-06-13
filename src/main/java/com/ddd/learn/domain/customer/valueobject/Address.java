package com.ddd.learn.domain.customer.valueobject;

public class Address {

    private String street;
    private Integer number;
    private String zip;
    private String city;

    public Address(String street, Integer number, String zip, String city) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;

        this.validate();
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public String getZip() {
        return zip;
    }

    public String getCity() {
        return city;
    }


    private void validate(){
        if(this.street.isBlank()){
            throw new NullPointerException("Street is required");
        }
        if (this.number == null && this.number.byteValue() == 0) {
            throw new NullPointerException("Number is required");
        }
        if(this.zip.isBlank()){
            throw new NullPointerException("Zip is required");
        }
        if(this.city.isBlank()){
            throw new NullPointerException("City is required");
        }
    }

    @Override
    public String toString() {
        return this.street + this.number + this.zip + this.city;
    }
}
