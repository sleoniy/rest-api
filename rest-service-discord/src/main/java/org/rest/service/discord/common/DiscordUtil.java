package org.rest.service.discord.common;

import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class DiscordUtil {

  private DiscordUtil() {

  }


  public static boolean deleteMessage(final GuildMessageReceivedEvent event) {
    event.getMessage().delete().complete();
    return true;
  }

  public static boolean sendEmbedMessage(final TextChannel channel,
      final MessageEmbed messageEmbed) {
    channel.sendMessage(messageEmbed).complete();
    return true;
  }
}
