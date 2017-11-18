package sample.parceldelivery.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import sample.parceldelivery.service.OrderDeliveryStatusService;

import java.util.List;

@RestController
@RequestScope
public class OrderDeliveryStatusController {

    @Autowired
    OrderDeliveryStatusService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<OrderDeliveryStatusUpdate> saveOrder(@RequestBody OrderDeliveryStatusUpdate status){
        service.processStatus(status);
        return ResponseEntity.ok(status);
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<List<OrderDeliveryStatusUpdate>> readOrder(@PathVariable Long orderId){
        return ResponseEntity.ok(service.getStatusForOrder(orderId));
    }

}
