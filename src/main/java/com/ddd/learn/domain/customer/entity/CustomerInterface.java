package com.ddd.learn.domain.customer.entity;

import com.ddd.learn.domain.customer.valueobject.Address;

public interface CustomerInterface {
    String getId();
    String getName();
    Address getAddress();
    Integer getPoits();
}
