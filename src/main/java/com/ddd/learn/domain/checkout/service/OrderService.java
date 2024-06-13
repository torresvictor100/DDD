package com.ddd.learn.domain.checkout.service;

import com.ddd.learn.domain.customer.entity.Customer;
import com.ddd.learn.domain.checkout.entity.Order;
import com.ddd.learn.domain.checkout.entity.OrderItem;

import java.util.List;

public class OrderService {

    public Integer total(List<Order> orderList){
        return orderList.stream()
                .mapToInt(Order::getTotal)
                .sum();
    }

    public void rewardPoints(Order order, Customer customer) {

        Integer poits =  order.getOrderItemList().stream()
                .mapToInt(OrderItem:: get_priceTotal).reduce(0, Integer::sum)/2;

        customer.addPoits(poits);

    }
}
