package sample.shoppingcart.service;

import sample.shoppingcart.model.Order;

import java.util.List;

public interface OrderService {
    void processOrder(Order order);

    List<Order> readOrderByCustomerId(Long customerId);
}
