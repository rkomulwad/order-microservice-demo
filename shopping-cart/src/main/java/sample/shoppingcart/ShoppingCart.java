package sample.shoppingcart;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import sample.shoppingcart.model.Order;
import sample.shoppingcart.model.OrderItem;
import sample.shoppingcart.service.OrderService;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingCart {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCart.class, args);
    }

    @Bean
    InitializingBean initData(OrderService service){
        return () -> {
            Order order = new Order();
            order.setCustomerId(1234l);
            order.setAddress("Test address");
            OrderItem item = new OrderItem();
            item.setProductId(666l);
            item.setQty(1);
            order.addOrderItem(item);
            item = new OrderItem();
            item.setProductId(777l);
            item.setQty(2);
            order.addOrderItem(item);
            service.processOrder(order);
        };
    }
}
