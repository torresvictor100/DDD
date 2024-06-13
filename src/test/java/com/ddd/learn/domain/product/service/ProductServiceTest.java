package com.ddd.learn.domain.product.service;

import com.ddd.learn.domain.UnitTest;
import com.ddd.learn.domain.product.entity.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@DataJpaTest
@ActiveProfiles("test")
public class ProductServiceTest extends UnitTest {

    @Test
    public void chancePrice(){
        Product product1 = new Product(UUID.randomUUID().toString(), "product1", 100);
        Product product2 = new Product(UUID.randomUUID().toString(), "product2", 50);

        List<Product> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        ProductService productService = new ProductService();

        productService.increasePrice(productList, 100);

        Assertions.assertEquals(product1.getPrice(), 200);
        Assertions.assertEquals(product2.getPrice(), 100);

    }
}
