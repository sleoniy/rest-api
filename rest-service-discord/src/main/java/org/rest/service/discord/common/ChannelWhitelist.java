package org.rest.service.discord.common;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelWhitelist {

  private static List<String> whitelist;

  public static List<String> getWhitelist() {
    return whitelist;
  }

  @Autowired
  public ChannelWhitelist(@Value("${discord.command.whitelist}") final List<String> whitelist) {
    ChannelWhitelist.whitelist = whitelist;
  }

  public ChannelWhitelist() {

  }
}
