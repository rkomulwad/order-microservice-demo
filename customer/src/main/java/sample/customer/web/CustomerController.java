package sample.customer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.customer.model.Order;
import sample.customer.service.CustomerOrderService;

import java.util.List;

@RestController
@RefreshScope
public class CustomerController {
    @Autowired
    CustomerOrderService service;

    @RequestMapping(value = "/{memberId}", method = RequestMethod.POST)
    public ResponseEntity<Order> saveOrder(@RequestBody Order order, @PathVariable Long memberId){
        order.setCustomerId(memberId);
        order = service.processOrder(order);
        return ResponseEntity.ok(order);
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> readOrder(@PathVariable("memberId") Long memberId){
        return ResponseEntity.ok(service.readOrderByCustomerId(memberId));
    }
}
