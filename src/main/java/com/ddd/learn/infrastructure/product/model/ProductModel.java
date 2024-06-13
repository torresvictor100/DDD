package com.ddd.learn.infrastructure.product.model;

import com.ddd.learn.infrastructure.checkout.model.OrderItemModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "\"product\"")
@Data
public class ProductModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "product_sq", allocationSize = 1)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemModel> orderItems;
}
