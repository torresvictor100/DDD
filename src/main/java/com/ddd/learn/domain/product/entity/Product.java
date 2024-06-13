package com.ddd.learn.domain.product.entity;

public class Product implements ProductInterface{
    private String id;
    private String name;
    private Integer price;

    public Product(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validate();
    }

    private void validate() {
        if(this.id == null ){
            throw new NullPointerException("Field id is null");
        }
        if(this.name.isBlank()){
            throw new NullPointerException("Field name required");
        }
        if(this.price < 0){
            throw new IllegalArgumentException("Can't negative price");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
