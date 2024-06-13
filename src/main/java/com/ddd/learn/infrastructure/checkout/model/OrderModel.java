package com.ddd.learn.infrastructure.checkout.model;

import com.ddd.learn.infrastructure.customer.model.CustomerModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "\"order\"")
@Data
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_sq", allocationSize = 1)
    private Long id;

    @Transient
    private Long customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerModel customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemModel> orderItems;

    @NotNull
    private Integer total;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void updateTransientFields() {
        this.customerId = customerId != null ? customer.getId() : null;
    }
}
