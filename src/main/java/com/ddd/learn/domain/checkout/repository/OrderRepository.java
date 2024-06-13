package com.ddd.learn.domain.checkout.repository;

import com.ddd.learn.domain.shared.repository.RepositoryInterface;
import com.ddd.learn.infrastructure.checkout.model.OrderModel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends RepositoryInterface<OrderModel, Long> {

}
