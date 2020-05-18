package org.rest.service.discord.adapters;

import org.rest.service.discord.common.ChannelWhitelist;
import org.rest.service.discord.common.DiscordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class AntiCommandAdapter extends ListenerAdapter {

  private final static Logger logger = LoggerFactory.getLogger(AntiCommandAdapter.class);

  @Override
  public void onReady(ReadyEvent event) {
    logger.info("AntiCommandAdapter has been initialized!");
  }

  @Override
  public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    final String message = event.getMessage().getContentRaw();
    final Member member = event.getMember();

    if (message == null || message.length() < 1 || message.charAt(0) != '!')
      return;

    final String username =
        member.getNickname() != null ? member.getNickname() : member.getUser().getName();

    if (!ChannelWhitelist.getWhitelist().contains(event.getChannel().getId())) {
      DiscordUtil.deleteMessage(event);

      DiscordUtil.sendEmbedMessage(event.getChannel(),
          DiscordUtil.buildWrongChannelEmbedMessage(username
              + ", please navigate to " + event.getGuild()
                  .getTextChannelById(ChannelWhitelist.getCommandChannel()).getAsMention()
              + " to execute a command"));

    }
  }
}
