package org.rest.service.discord.adapters;

import org.rest.service.discord.common.ChannelWhitelist;
import org.rest.service.discord.common.DiscordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
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
    final Message message = event.getMessage();
    final Member member = event.getMember();

    if (message == null || message.getContentRaw().length() < 1)
      return;

    if (message.getContentRaw().charAt(0) == '!') {
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
}
