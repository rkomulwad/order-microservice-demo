package sample.parceldelivery.service;


import sample.parceldelivery.web.OrderDeliveryStatusUpdate;

import java.util.List;

public interface OrderDeliveryStatusService {
    void processStatus(OrderDeliveryStatusUpdate status);

    List<OrderDeliveryStatusUpdate> getStatusForOrder(Long orderId);
}
