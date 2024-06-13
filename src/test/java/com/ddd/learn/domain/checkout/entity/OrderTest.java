package com.ddd.learn.domain.checkout.entity;

import com.ddd.learn.domain.UnitTest;
import com.ddd.learn.domain.checkout.entity.Order;
import com.ddd.learn.domain.checkout.entity.OrderItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class OrderTest extends UnitTest {

    @Test
    public void order(){
        final var expectationTotal = 100;

        List<OrderItem> orderItemList = new ArrayList<>();
        final var orderItem1 = new OrderItem("1", "1","produto1", 20, 1);
        orderItemList.add(orderItem1);
        final var orderItem2 = new OrderItem("2", "1","produto2", 30, 1);
        orderItemList.add(orderItem2);
        final var orderItem3 = new OrderItem("3", "1","produto3", 25,2);
        orderItemList.add(orderItem3);


        //order
        final var order = new Order( "123", orderItemList);

        Assertions.assertNotNull(order);
        Assertions.assertNotNull(order.getUuid());
        Assertions.assertNotNull(order.getCustomerId());
        Assertions.assertNotNull(order.getTotal());
        Assertions.assertEquals(expectationTotal, order.getTotal());



    }
}
