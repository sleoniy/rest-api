package org.rest.service.discord.adapters;

import java.awt.Color;
import org.rest.service.discord.common.ChannelWhitelist;
import org.rest.service.discord.common.DiscordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

@ComponentScan
@EnableAutoConfiguration
public class AntiCommandAdapter extends ListenerAdapter {

  private final static Logger logger = LoggerFactory.getLogger(AntiCommandAdapter.class);

  @Override
  public void onReady(ReadyEvent event) {
    logger.info("AntiCommandAdapter has been initialized!");
  }

  @Override
  public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

    final String message = event.getMessage().getContentRaw();
    if (message == null || message.length() < 1 || message.charAt(0) != '!')
      return;

    if (!ChannelWhitelist.getWhitelist().contains(event.getChannel().getId())) {
      final EmbedBuilder eb = new EmbedBuilder();
      eb.setTitle("WARNING");

      final String username =
          event.getMember().getNickname() != null ? event.getMember().getNickname()
              : event.getMember().getUser().getName();

      eb.addField("",
          username + ", please navigate to "
              + event.getGuild().getTextChannelById("704790244280500326").getAsMention()
              + " to execute a command",
          true);

      eb.setColor(Color.red);

      DiscordUtil.deleteMessage(event);
      DiscordUtil.sendEmbedMessage(event.getChannel(), eb.build());

    }
  }
}
