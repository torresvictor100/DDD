package com.ddd.learn.domain.product.event;

import com.ddd.learn.domain.product.entity.Product;
import com.ddd.learn.domain.shared.event.EventAbstract;

import java.time.LocalDateTime;

public class ProductCreatedEvent extends EventAbstract {

    public ProductCreatedEvent(Product eventData) {
        super(LocalDateTime.now(), eventData);
    }
}
