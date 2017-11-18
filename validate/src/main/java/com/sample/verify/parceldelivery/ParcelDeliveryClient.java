package com.sample.verify.parceldelivery;

import com.sample.verify.config.CustomFeignConfiguration;
import com.sample.verify.parceldelivery.model.OrderDeliveryStatusUpdate;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "PARCELDELIVERY", configuration = CustomFeignConfiguration.class)
public interface ParcelDeliveryClient {

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public OrderDeliveryStatusUpdate saveOrder(@RequestBody OrderDeliveryStatusUpdate status);

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public List<OrderDeliveryStatusUpdate> readOrder(@PathVariable("orderId") Long orderId);

}
