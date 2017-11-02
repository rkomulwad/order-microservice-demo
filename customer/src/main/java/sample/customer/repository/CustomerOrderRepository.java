package sample.customer.repository;

import org.springframework.data.repository.CrudRepository;
import sample.customer.model.Order;

import java.util.List;

public interface CustomerOrderRepository extends CrudRepository<Order, Long>{
    List<Order> findByCustomerId(Long memberId);
}
