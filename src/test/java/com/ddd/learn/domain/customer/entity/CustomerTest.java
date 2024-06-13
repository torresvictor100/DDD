package com.ddd.learn.domain.customer.entity;

import com.ddd.learn.domain.UnitTest;
import com.ddd.learn.domain.customer.valueobject.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class CustomerTest extends UnitTest {

    @Test
    public void customer(){
        final var expectationName = "CustomerName";
        //address
        final var expectationStreet = "Rua y";
        final var expectationNumber = 87;
        final var expectationZip = "12345-67";
        final var expectationCity = "cidade x";

        final var address = new Address(expectationStreet, expectationNumber, expectationZip, expectationCity);

        final var customer =
                new Customer("CustomerName");

        //activate without address
        Assertions.assertEquals(false, customer.isActive());
        Assertions.assertThrows(NullPointerException.class,() ->  {customer.activate();});


        customer.setAddress(address);
        customer.activate();

        customer.setAddress(address);

        Assertions.assertNotNull(customer);
        Assertions.assertNotNull(customer.getId());
        Assertions.assertNotNull(customer.recoverName());
        Assertions.assertEquals(expectationName, customer.recoverName());
        Assertions.assertNotNull(customer.isActive());
        Assertions.assertEquals(true, customer.isActive());

        //address
        Assertions.assertNotNull(customer.getAddress());
        Assertions.assertNotNull(customer.getAddress().getStreet());
        Assertions.assertEquals(expectationStreet, customer.getAddress().getStreet());
        Assertions.assertNotNull(customer.getAddress().getNumber());
        Assertions.assertEquals(expectationNumber, customer.getAddress().getNumber());
        Assertions.assertNotNull(customer.getAddress().getZip());
        Assertions.assertEquals(expectationZip, customer.getAddress().getZip());
        Assertions.assertNotNull(customer.getAddress().getCity());
        Assertions.assertEquals(expectationCity, customer.getAddress().getCity());
    }

    @Test
    public void addPoints(){

        final var address = new Address("Rua y", 87, "12345-67", "cidade x");

        Customer customer = new Customer("customer");

        Assertions.assertThrows(IllegalArgumentException.class,() ->  {customer.addPoits(1);});

        customer.setAddress(address);
        customer.activate();

        customer.addPoits(-1);
        Assertions.assertEquals(0, customer.getPoits());
        customer.addPoits(20);
        Assertions.assertEquals(20, customer.getPoits());
    }

}
