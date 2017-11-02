package sample.shoppingcart.repository;

import org.springframework.data.repository.CrudRepository;
import sample.shoppingcart.model.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long>{
    List<Order> findByCustomerId(Long memberId);
}
