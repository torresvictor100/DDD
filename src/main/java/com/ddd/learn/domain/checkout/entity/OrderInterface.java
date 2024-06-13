package com.ddd.learn.domain.checkout.entity;

import java.util.List;

public interface OrderInterface {
    String getUuid();
    String getCustomerId();
    List<OrderItem> getOrderItemList();
    Integer getTotal();
}
