package com.ddd.learn.domain.checkout.service;

import com.ddd.learn.domain.customer.entity.Customer;
import com.ddd.learn.domain.checkout.entity.Order;
import com.ddd.learn.domain.checkout.entity.OrderItem;
import com.ddd.learn.domain.customer.valueobject.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class OrderServiceTest {

    @Test
    public void sumTotalOrders(){
        OrderItem orderItem1 = new OrderItem("1", "1", "orderItem1", 100, 1);
        OrderItem orderItem2 = new OrderItem("2", "2", "orderItem2", 50, 2);
        OrderItem orderItem3 = new OrderItem("3", "3", "orderItem3", 25, 4);

        List<OrderItem> orderItemList1 = new ArrayList<>();
        orderItemList1.add(orderItem1);

        List<OrderItem> orderItemList2 = new ArrayList<>();
        orderItemList2.add(orderItem2);
        orderItemList2.add(orderItem3);

        Order order1 = new Order("1", orderItemList1);
        Order order2 = new Order("1", orderItemList2);

        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);

        OrderService orderService = new OrderService();

        Integer total = orderService.total(orderList);

        Assertions.assertEquals(total, 300);

    }

    @Test
    public void rewardPoints(){

        OrderItem orderItem1 = new OrderItem("1", "1", "orderItem1", 100, 1);
        OrderItem orderItem2 = new OrderItem("2", "2", "orderItem2", 50, 2);

        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem1);
        orderItemList.add(orderItem2);


        OrderService orderService = new OrderService();

        Customer customer = new Customer("customer");

        Order order = new Order(customer.getId() ,orderItemList);

        Address address = new Address("Street", 87, "zip", "city");
        customer.setAddress(address);

        customer.activate();

        orderService.rewardPoints(order, customer);

        Assertions.assertEquals(customer.getPoits(), 100);

    }

}
