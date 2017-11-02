package sample.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.shoppingcart.model.Order;
import sample.shoppingcart.repository.OrderRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public void processOrder(Order order) {
        order.setOrderDateTime(ZonedDateTime.now());
        orderRepository.save(order);
    }

    public List<Order> readOrderByCustomerId(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
}
