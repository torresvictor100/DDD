package com.ddd.learn.domain.product.repository;

import com.ddd.learn.infrastructure.product.model.ProductModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.NoSuchElementException;

@DataJpaTest
@ActiveProfiles("test")
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testProduct(){
        ProductModel product1 = new ProductModel();
        ProductModel product2 = new ProductModel();

        product2.setName("productSave2");
        product2.setPrice(2);
        //Save

        product1.setName("productSave1");
        product1.setPrice(1);

        ProductModel productSave1 = productRepository.save(product1);
        productRepository.save(product2);

        Assertions.assertEquals(productSave1.getName(), "productSave1");
        Assertions.assertEquals(productSave1.getPrice(), 1);

        //FindById

        ProductModel productFound = productRepository.findById(productSave1.getId()).get();
        Assertions.assertEquals(productSave1.getId(), productFound.getId());

        //FindAll

        List<ProductModel> productModelList = productRepository.findAll();
        Assertions.assertEquals(2, productModelList.size());


        //Update

        productFound.setName("productFound");

        ProductModel productUpdate = productRepository.save(productSave1);
        Assertions.assertEquals(productSave1.getId(), productUpdate.getId());
        Assertions.assertEquals("productFound", productUpdate.getName());

        //delete

        productRepository.delete(productUpdate);
        Assertions.assertThrows(NoSuchElementException.class,() ->  {productRepository.findById(productUpdate.getId()).get();});
    }
}
