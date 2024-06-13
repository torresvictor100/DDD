package com.ddd.learn.infrastructure.checkout.model;

import com.ddd.learn.infrastructure.product.model.ProductModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Table(name = "\"orderitem\"")
@Data
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderitem_generator")
    @SequenceGenerator(name = "orderitem_generator", sequenceName = "orderitem_sq", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private Integer quantity;

    @Transient
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;

    @Transient
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel order;

    @PostLoad
    @PostPersist
    @PostUpdate
    private void updateTransientFields() {
        this.productId = product != null ? product.getId() : null;
        this.orderId = order != null ? order.getId() : null;
    }
}
