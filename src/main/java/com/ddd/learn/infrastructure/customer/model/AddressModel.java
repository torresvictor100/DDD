package com.ddd.learn.infrastructure.customer.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AddressModel {

    private String street;
    private Integer number;
    private String zip;
    private String city;
}
