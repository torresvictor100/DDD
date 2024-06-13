package com.ddd.learn.domain.product.repository;

import com.ddd.learn.domain.shared.repository.RepositoryInterface;
import com.ddd.learn.infrastructure.product.model.ProductModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends RepositoryInterface<ProductModel, Long> {

}
