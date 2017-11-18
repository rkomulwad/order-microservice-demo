package com.sample.verify.web;

import com.netflix.discovery.converters.Auto;
import com.sample.verify.customer.CustomerServiceClient;
import com.sample.verify.customer.model.Order;
import com.sample.verify.parceldelivery.ParcelDeliveryClient;
import com.sample.verify.parceldelivery.model.OrderDeliveryStatusUpdate;
import com.sample.verify.shoppingcart.ShoppingCartClient;
import com.sample.verify.shoppingcart.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

@RestController
@EnableDiscoveryClient
public class ValidateController {

    @Autowired
    CustomerServiceClient customerServiceClient;

    @Autowired
    ShoppingCartClient shoppingCartClient;

    @Autowired
    ParcelDeliveryClient parcelDeliveryClient;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity validate(){
        try{
            System.out.println("1. Saving Shopping Cart Order");
            com.sample.verify.shoppingcart.model.Order shoppingCartOrder = new com.sample.verify.shoppingcart.model.Order();
            shoppingCartOrder.setAddress("TEXAS");
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(111l);
            orderItem.setQty(1);
            shoppingCartOrder.getOrderItems().add(orderItem);

            shoppingCartOrder = shoppingCartClient.saveOrder(1234l ,shoppingCartOrder);

            System.out.println("2. Saved Shopping Cart Order - "+shoppingCartOrder);

            List<com.sample.verify.shoppingcart.model.Order> shoppingCartOrders = shoppingCartClient.readOrder(1234l);
            shoppingCartOrders.forEach(System.out::println);

            System.out.println("3. Reading Customer Orders");
            List<Order> customerOrders = customerServiceClient.readOrder(1234l);

            customerOrders.forEach(System.out::println);

            System.out.println("4. Placing Customer Orders");
            Order customerOrder = new Order();
            customerOrder.setAddress("test address");

            Order orderSaved = customerServiceClient.saveOrder(1234l, customerOrder);

            System.out.println("5. Saved Customer Order - "+orderSaved);

            OrderDeliveryStatusUpdate orderDeliveryStatusUpdate = new OrderDeliveryStatusUpdate();
            orderDeliveryStatusUpdate.setOrderId(orderSaved.getId());
            orderDeliveryStatusUpdate.setLocation("DFW");

            parcelDeliveryClient.saveOrder(orderDeliveryStatusUpdate);

            System.out.println("6. Saved Order status update - "+orderDeliveryStatusUpdate);

            List<OrderDeliveryStatusUpdate> statusUpdates = parcelDeliveryClient.readOrder(orderSaved.getId());

            statusUpdates.forEach(System.out::println);

            System.out.println("10. PASS ");

            return ResponseEntity.ok().build();
        } catch(Exception e){
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return new ResponseEntity(exceptionAsString, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
