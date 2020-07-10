package org.rest.service.swipe.common;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChannelWhitelist {

  private static List<String> whitelistChannels;
  private static String commandChannel;

  public static List<String> getWhitelist() {
    return whitelistChannels;
  }

  public static String getCommandChannel() {
    return commandChannel;
  }

  @Autowired
  public ChannelWhitelist(
      @Value("${discord.command.whitelist}") final List<String> whitelistChannels,
      @Value("${discord.command.channel}") final String commandChannel) {
    ChannelWhitelist.whitelistChannels = whitelistChannels;
    ChannelWhitelist.commandChannel = commandChannel;
  }
}
