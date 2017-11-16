package sample.shoppingcart.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.shoppingcart.model.Order;
import sample.shoppingcart.service.OrderService;

import java.util.List;


@RestController
@RefreshScope
public class CartController {

    @Autowired
    OrderService service;

    @RequestMapping(value = "/{memberId}", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> saveOrder(@RequestBody Order order){
        service.processOrder(order);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> readOrder(@PathVariable Long memberId){
        return ResponseEntity.ok(service.readOrderByCustomerId(memberId));
    }
}
