package org.rest.service.swipe;

import javax.security.auth.login.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class Application {

  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws LoginException {
    logger.info("Initializing REST Swype...");

    SpringApplication.run(Application.class, args);

    logger.info("Initializion complete.");
  }
}
