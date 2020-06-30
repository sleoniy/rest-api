package org.rest.service.discord;

import javax.security.auth.login.LoginException;
import org.rest.service.discord.adapters.AntiCommandAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

@SpringBootApplication(proxyBeanMethods = false)
public class App {


  public static void main(String[] args) throws LoginException {

    SpringApplication.run(App.class, args);
    JDA jda = new JDABuilder(null).build();
    jda.addEventListener(new AntiCommandAdapter());
  }
}
