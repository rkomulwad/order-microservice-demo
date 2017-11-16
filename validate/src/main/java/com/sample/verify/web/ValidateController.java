package com.sample.verify.web;

import com.sample.verify.customer.CustomerServiceClient;
import com.sample.verify.customer.model.Order;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity validate(){
        try{
            System.out.println("Reading Customer Orders");
            List<Order> customerOrders = customerServiceClient.readOrder(1234l);

            customerOrders.forEach(System.out::println);

            System.out.println("Placing Customer Orders");
            Order customerOrder = new Order();
            customerOrder.setAddress("test address");

            Order orderSaved = customerServiceClient.saveOrder(1234l, customerOrder);

            System.out.println("Saved Customer Order - "+customerOrder);

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
