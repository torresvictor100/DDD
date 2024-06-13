package com.ddd.learn.domain.product.service;

import com.ddd.learn.domain.product.entity.Product;

import java.util.List;

public class ProductService {

    //se fose 1 milhão de produtos não faz sentido fazer isso, seria melhor
    //fazer direto no banco
    public void increasePrice(List<Product> productList, Integer percentage) {
        productList.forEach(product -> {
            int currentPrice = product.getPrice();
            product.setPrice(currentPrice + (currentPrice * percentage / 100));
        });
    }
}
