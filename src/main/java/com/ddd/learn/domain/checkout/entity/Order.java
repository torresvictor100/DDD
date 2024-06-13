package com.ddd.learn.domain.checkout.entity;

import java.util.List;
import java.util.UUID;

public class Order implements OrderInterface{
    private String uuid;
    private String customerId;
    private List<OrderItem> orderItemList;
    private Integer total;

    public Order(String customerId, List<OrderItem> orderItemList) {
        this.uuid = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.orderItemList = orderItemList;
        this.total = this.total(orderItemList);
        this.validate();
    }

    private void validate(){
        if(this.uuid == null){
            throw new NullPointerException("Field id is null");
        }
        if(this.customerId == null){
            throw new NullPointerException("Field customerId required");
        }
        if(this.orderItemList.isEmpty()){
            throw new NullPointerException("Field order required");
        }
    }

    private Integer total(List<OrderItem> orderItemList){
        return orderItemList.stream().mapToInt(OrderItem::get_priceTotal).reduce(0, Integer::sum);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
