package com.ddd.learn.domain.checkout.repository;

import com.ddd.learn.domain.customer.repository.CustomerRepository;
import com.ddd.learn.domain.product.repository.ProductRepository;
import com.ddd.learn.infrastructure.checkout.model.OrderItemModel;
import com.ddd.learn.infrastructure.checkout.model.OrderModel;
import com.ddd.learn.infrastructure.customer.model.AddressModel;
import com.ddd.learn.infrastructure.customer.model.CustomerModel;
import com.ddd.learn.infrastructure.product.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void orderTest(){

        ProductModel product = new ProductModel();
        product.setPrice(100);
        product.setName("product");
        product = productRepository.save(product);

        AddressModel address = new AddressModel();

        address.setStreet("Street");
        address.setZip("Zip");
        address.setCity("City");
        address.setNumber(87);

        CustomerModel customerModel = new CustomerModel();

        customerModel.setName("custume");
        customerModel.setPoits(0);
        customerModel.setAddress(address);
        customerModel.setUuid("uuid");

        customerRepository.save(customerModel);

        OrderModel orderModel = new OrderModel();
        orderModel.setCustomer(customerModel);
        orderModel.setTotal(100);

        OrderItemModel orderItem = new OrderItemModel();
        orderItem.setName("orderItem");
        orderItem.setPrice(0);
        orderItem.setProduct(product);

        List<OrderItemModel> orderItemList = new ArrayList<>();
        orderItemList.add(orderItem);

        orderItem.setOrder(orderModel);
        orderModel.setOrderItems(orderItemList);

        orderRepository.save(orderModel);

        Assertions.assertNotNull(orderModel);
        Assertions.assertNotNull(orderModel.getOrderItems());

    }
}
