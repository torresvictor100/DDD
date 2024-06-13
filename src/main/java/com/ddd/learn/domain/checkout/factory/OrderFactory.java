package com.ddd.learn.domain.checkout.factory;

import com.ddd.learn.domain.checkout.entity.Order;
import com.ddd.learn.domain.checkout.entity.OrderInterface;
import com.ddd.learn.domain.checkout.entity.OrderItem;

import java.util.List;

public class OrderFactory {
    public static OrderInterface create(String customerId, List<OrderItem> orderItemList) {
        return new Order(customerId, orderItemList);
    }
}
