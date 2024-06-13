package com.ddd.learn.domain.shared.customer;

import com.ddd.learn.domain.customer.entity.Customer;
import com.ddd.learn.domain.shared.event.EventAbstract;

import java.time.LocalDateTime;

public class CustomerCreatedEvent extends EventAbstract {
    public CustomerCreatedEvent( Customer eventData) {
        super(LocalDateTime.now(), eventData);
    }
}
