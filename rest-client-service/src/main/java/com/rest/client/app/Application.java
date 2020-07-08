package com.rest.client.app;


import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.rest.client.proxy", "com.rest.client.config"})
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);


  public static void main(String[] args) throws IOException, InterruptedException {
    logger.info("Initializing REST Client...");

    SpringApplication.run(Application.class, args);

    logger.info("Initializion complete.");
  }
}
