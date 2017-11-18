package com.sample.verify.shoppingcart;

import com.sample.verify.config.CustomFeignConfiguration;
import com.sample.verify.shoppingcart.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "SHOPPINGCART", configuration = CustomFeignConfiguration.class)
public interface ShoppingCartClient {

    @RequestMapping(value = "/{memberId}", method = RequestMethod.POST)
    public Order saveOrder(@PathVariable("memberId") Long memberId, @RequestBody Order order);

    @RequestMapping(value = "/{memberId}", method = RequestMethod.GET)
    public List<Order> readOrder(@PathVariable("memberId") Long memberId);
}
