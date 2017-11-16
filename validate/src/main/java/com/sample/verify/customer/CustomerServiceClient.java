package com.sample.verify.customer;

import com.sample.verify.config.CustomFeignConfiguration;
import com.sample.verify.customer.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "CUSTOMER", configuration = CustomFeignConfiguration.class)
public interface CustomerServiceClient {
    @RequestMapping(method = RequestMethod.POST, value = "/{memberId}", consumes = "application/json")
    Order saveOrder(@PathVariable("memberId") Long memberId, Order order);

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public List<Order> readOrder(@PathVariable("memberId") Long memberId);
}
