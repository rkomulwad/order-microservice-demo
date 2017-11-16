package com.sample.verify.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFeignConfiguration {

    @Bean
    public feign.Logger.Level feignLoggerLevel() {
        return feign.Logger.Level.FULL;
    }
}
