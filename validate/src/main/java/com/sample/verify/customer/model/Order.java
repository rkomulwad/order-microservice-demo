package com.sample.verify.customer.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;

    private Long customerId;
    private String address;
    private String orderDateTime;
    private String estimateTimeOfArrival;
    private String actualDeliveredDateTime;


    private List<OrderItem> orderItems = new ArrayList<>();

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

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getEstimateTimeOfArrival() {
        return estimateTimeOfArrival;
    }

    public void setEstimateTimeOfArrival(String estimateTimeOfArrival) {
        this.estimateTimeOfArrival = estimateTimeOfArrival;
    }

    public String getActualDeliveredDateTime() {
        return actualDeliveredDateTime;
    }

    public void setActualDeliveredDateTime(String actualDeliveredDateTime) {
        this.actualDeliveredDateTime = actualDeliveredDateTime;
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
                ", estimateTimeOfArrival=" + estimateTimeOfArrival +
                ", actualDeliveredDateTime=" + actualDeliveredDateTime +
                ", orderItems=" + orderItems +
                '}';
    }
}
