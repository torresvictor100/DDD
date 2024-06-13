package com.ddd.learn.domain.customer.factory;

import com.ddd.learn.domain.customer.entity.Customer;
import com.ddd.learn.domain.customer.entity.CustomerInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class CustomerFactoryTest {

    @Test
    void customer(){

        CustomerInterface customer = CustomerFactory.create("customer");

        Assertions.assertNotNull(customer);
        Assertions.assertEquals(Customer.class, customer.getClass());
        Assertions.assertEquals("customer", customer.getName());
        Assertions.assertEquals(0, customer.getPoits());
        Assertions.assertNull(customer.getAddress());

    }

    @Test
    void customerWithAdress(){

        CustomerInterface customer = CustomerFactory.create("customer","street"
                , 87, "zip", "city" );

        Assertions.assertNotNull(customer);
        Assertions.assertEquals(Customer.class, customer.getClass());
        Assertions.assertEquals("customer", customer.getName());
        Assertions.assertEquals(0, customer.getPoits());
        Assertions.assertNotNull(customer.getAddress());

    }
}
