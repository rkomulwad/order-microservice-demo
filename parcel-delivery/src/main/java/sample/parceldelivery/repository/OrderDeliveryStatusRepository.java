package sample.parceldelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.parceldelivery.model.OrderDeliveryStatus;

import java.util.List;

@Repository
public interface OrderDeliveryStatusRepository extends CrudRepository<OrderDeliveryStatus, Long>{
    List<OrderDeliveryStatus> findByOrderId(Long orderId);
}
