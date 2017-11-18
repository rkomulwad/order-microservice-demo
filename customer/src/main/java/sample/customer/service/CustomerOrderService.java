package sample.customer.service;


import sample.customer.model.Order;

import java.util.List;

public interface CustomerOrderService {
    Order processOrder(Order order);

    List<Order> readOrderByCustomerId(Long customerId);
}
