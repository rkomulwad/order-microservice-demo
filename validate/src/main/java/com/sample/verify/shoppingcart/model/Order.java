package com.sample.verify.shoppingcart.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;

    private Long customerId;
    private String address;
    private ZonedDateTime orderDateTime;

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addOrderItem(OrderItem item){
        orderItems.add(item);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ZonedDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(ZonedDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", address='" + address + '\'' +
                ", orderDateTime=" + orderDateTime +
                ", orderItems=" + orderItems +
                '}';
    }
}
