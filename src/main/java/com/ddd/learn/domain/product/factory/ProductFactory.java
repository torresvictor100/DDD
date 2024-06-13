package com.ddd.learn.domain.product.factory;

import com.ddd.learn.domain.product.entity.Product;
import com.ddd.learn.domain.product.entity.ProductB;
import com.ddd.learn.domain.product.entity.ProductInterface;
import jakarta.persistence.EntityNotFoundException;

import java.util.UUID;

public class ProductFactory {
    public static ProductInterface create(String type, String product, Integer price) {
        if(type.equals("a")){
            return new Product(UUID.randomUUID().toString(), product, price);
        }else if(type.equals("b")){
            return new ProductB(UUID.randomUUID().toString(), product, price);
        }
        throw new EntityNotFoundException("tipo errado");
    }
}
