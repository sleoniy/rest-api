package org.rest.service.discord;

import javax.security.auth.login.LoginException;
import org.rest.service.discord.adapters.BettingAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

@SpringBootApplication(proxyBeanMethods = false)
public class App {


  public static void main(String[] args) throws LoginException {

    SpringApplication.run(App.class, args);
    // final JDA jda = new JDABuilder(UtiLittyConstants.UTILITTY_ID).build();
    final JDA jda =
        new JDABuilder("NzE5Mjc2Nzk3OTI0OTk5MTg5.Xt1EvQ.BGR-hfM4lg3S0OqegtPUxwyECck").build();
    jda.addEventListener(new BettingAdapter());

  }
}
