package sample.customer.service;


import sample.customer.model.Order;

import java.util.List;

public interface CustomerOrderService {
    void processOrder(Order order);

    List<Order> readOrderByCustomerId(Long customerId);
}
