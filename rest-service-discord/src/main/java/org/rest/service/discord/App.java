package org.rest.service.discord;

import javax.security.auth.login.LoginException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class App {


  public static void main(String[] args) throws LoginException {

    SpringApplication.run(App.class, args);
    // final JDA jda = new JDABuilder(UtiLittyConstants.UTILITTY_ID).build();
  }
}
