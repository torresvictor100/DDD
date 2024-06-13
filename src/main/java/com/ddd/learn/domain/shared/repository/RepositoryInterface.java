package com.ddd.learn.domain.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryInterface<T, ID>  extends JpaRepository<T, ID> {
}
