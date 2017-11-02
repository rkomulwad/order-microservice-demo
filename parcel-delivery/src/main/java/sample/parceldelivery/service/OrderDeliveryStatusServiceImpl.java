package sample.parceldelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.parceldelivery.model.OrderDeliveryStatus;
import sample.parceldelivery.repository.OrderDeliveryStatusRepository;
import sample.parceldelivery.web.OrderDeliveryStatusUpdate;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderDeliveryStatusServiceImpl implements OrderDeliveryStatusService {

    @Autowired
    OrderDeliveryStatusRepository statusRepository;

    @Override
    public void processStatus(OrderDeliveryStatusUpdate status) {
        Date eventTime = Optional.ofNullable(status.getEventTime()).orElse(new Date());
        OrderDeliveryStatus deliveryStatus = new OrderDeliveryStatus();
        deliveryStatus.setOrderId(status.getOrderId());
        deliveryStatus.setEventTime(eventTime);
        deliveryStatus.setEventType(status.getEventType());
        deliveryStatus.setLocation(status.getLocation());

        statusRepository.save(deliveryStatus);
    }

    @Override
    public List<OrderDeliveryStatusUpdate> getStatusForOrder(Long orderId) {
        return StreamSupport.stream(statusRepository
                .findByOrderId(orderId).spliterator(), false)
                .map(s -> {
                    OrderDeliveryStatusUpdate statusUpdate = new OrderDeliveryStatusUpdate();
                    statusUpdate.setEventTime(s.getEventTime());
                    statusUpdate.setEventType(s.getEventType());
                    statusUpdate.setLocation(s.getLocation());
                    statusUpdate.setOrderId(s.getOrderId());
                    return statusUpdate;
                })
                .collect(Collectors.toList());
    }
}
