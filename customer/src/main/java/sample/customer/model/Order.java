package sample.customer.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private String address;
    private ZonedDateTime orderDateTime;
    private ZonedDateTime estimateTimeOfArrival;
    private ZonedDateTime actualDeliveredDateTime;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
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

    public ZonedDateTime getEstimateTimeOfArrival() {
        return estimateTimeOfArrival;
    }

    public void setEstimateTimeOfArrival(ZonedDateTime estimateTimeOfArrival) {
        this.estimateTimeOfArrival = estimateTimeOfArrival;
    }

    public ZonedDateTime getActualDeliveredDateTime() {
        return actualDeliveredDateTime;
    }

    public void setActualDeliveredDateTime(ZonedDateTime actualDeliveredDateTime) {
        this.actualDeliveredDateTime = actualDeliveredDateTime;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
