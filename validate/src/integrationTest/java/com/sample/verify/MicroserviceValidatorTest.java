package com.sample.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableFeignClients
public class MicroserviceValidatorTest {


    @Test
    public void test(){
        System.out.println("------------------ Integration test");
    }
}
