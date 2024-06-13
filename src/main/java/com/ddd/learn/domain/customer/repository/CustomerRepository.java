package com.ddd.learn.domain.customer.repository;

import com.ddd.learn.domain.shared.repository.RepositoryInterface;
import com.ddd.learn.infrastructure.customer.model.CustomerModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends RepositoryInterface<CustomerModel, Long> {

}
