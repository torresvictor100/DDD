package com.ddd.learn.domain.checkout.entity;

public class OrderItem {
    private String id;
    private String productId;
    private String name;
    private Integer price;
    private Integer quantity;

    public OrderItem(String id, String productId,String name
            , Integer price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.validate();
    }

    private void validate() {
        if(this.id == null){
            throw new NullPointerException("Field id is null");
        }
        if(this.name.isBlank()){
            throw new NullPointerException("Field name required");
        }
        if(this.productId == null){
            throw new NullPointerException("Field productId required");
        }
        if(this.price < 0){
            throw new IllegalArgumentException("Can't negative price");
        }
        if(this.quantity < 0){
            throw new IllegalArgumentException("Can't 0 _quantity");
        }
        if(this.quantity == null){
            throw new NullPointerException("Field quantity required");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.validate();
    }

    public Integer get_priceTotal() {
        return price * quantity;
    }

    public void setPrice(Integer price) {
        this.price = price;
        this.validate();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
        this.validate();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        this.validate();
    }
}
