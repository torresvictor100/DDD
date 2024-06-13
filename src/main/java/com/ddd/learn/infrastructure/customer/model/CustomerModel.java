package com.ddd.learn.infrastructure.customer.model;

import com.ddd.learn.infrastructure.checkout.model.OrderModel;
import com.ddd.learn.infrastructure.customer.model.AddressModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "\"customer\"")
@Data
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_sq", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    @Embedded
    @NotNull
    private AddressModel address;

    private Integer poits;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderModel> orders;

    @NotNull
    private String uuid;
}
