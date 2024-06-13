package com.ddd.learn.domain.customer.factory;

import com.ddd.learn.domain.customer.entity.Customer;
import com.ddd.learn.domain.customer.entity.CustomerInterface;
import com.ddd.learn.domain.customer.valueobject.Address;

public class CustomerFactory {

    public static CustomerInterface create(String name){
        return new Customer(name);
    }

    public static CustomerInterface create(String name, String street, Integer number, String zip,String city){
        Customer customer = new Customer(name);
        Address address = new Address(street, number, zip, city);
        customer.setAddress(address);
        return customer;
    }
}
