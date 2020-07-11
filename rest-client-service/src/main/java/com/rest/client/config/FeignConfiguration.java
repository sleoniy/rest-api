package com.rest.client.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.rest.client.proxy")
public class FeignConfiguration {

}
