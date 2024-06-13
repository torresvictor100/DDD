package com.ddd.learn.domain.product.factory;

import com.ddd.learn.domain.product.entity.Product;
import com.ddd.learn.domain.product.entity.ProductB;
import com.ddd.learn.domain.product.entity.ProductInterface;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class ProductFactoryTest {

    @Test
    public void productA(){
        ProductInterface product = ProductFactory.create( "a","product", 2);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(Product.class, product.getClass());
        Assertions.assertEquals("product", product.getName());
        Assertions.assertEquals(2, product.getPrice());
    }

    @Test
    public void productB(){
        ProductInterface product = ProductFactory.create( "b","product", 2);

        Assertions.assertNotNull(product);
        Assertions.assertEquals(ProductB.class, product.getClass());
        Assertions.assertEquals("product", product.getName());
        Assertions.assertEquals(4, product.getPrice());
    }

    @Test
    public void productC(){

        Assertions.assertThrows(EntityNotFoundException.class, () -> {
            ProductFactory.create("c", "product", 2);
        });
    }
}
