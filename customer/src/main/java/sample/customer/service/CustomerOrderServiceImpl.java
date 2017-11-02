package sample.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.customer.model.Order;
import sample.customer.repository.CustomerOrderRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

    @Autowired
    CustomerOrderRepository orderRepository;

    @Override
    public void processOrder(Order order) {
        order.setOrderDateTime(ZonedDateTime.now());
        orderRepository.save(order);
    }

    public List<Order> readOrderByCustomerId(Long customerId){
        return orderRepository.findByCustomerId(customerId);
    }
}
