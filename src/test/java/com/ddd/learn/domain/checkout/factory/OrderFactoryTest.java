package com.ddd.learn.domain.checkout.factory;

import com.ddd.learn.domain.checkout.entity.Order;
import com.ddd.learn.domain.checkout.entity.OrderInterface;
import com.ddd.learn.domain.checkout.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class OrderFactoryTest {
    @Test
    void orderCreate(){
        OrderItem orderItem = new OrderItem("123", "123", "orderItem", 2, 1 );
        List<OrderItem> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);

        OrderInterface order = OrderFactory.create("1", orderItemList);

        Assertions.assertNotNull(order);
        Assertions.assertEquals("1", order.getCustomerId());
        Assertions.assertEquals(1, order.getOrderItemList().size());
        Assertions.assertEquals("123", order.getOrderItemList().get(0).getId());
        Assertions.assertEquals(Order.class, order.getClass());

    }
}
