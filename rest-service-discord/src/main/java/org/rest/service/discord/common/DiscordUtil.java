package org.rest.service.discord.common;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class DiscordUtil {

  private DiscordUtil() {}


  public static boolean deleteMessage(final GuildMessageReceivedEvent event) {
    event.getMessage().delete().complete();
    return true;
  }

  public static boolean sendEmbedMessage(final TextChannel channel,
      final MessageEmbed messageEmbed) {
    channel.sendMessage(messageEmbed).complete();
    return true;
  }

  public static MessageEmbed buildWrongChannelEmbedMessage(final String message) {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("WARNING");
    eb.addField("", message, true);
    return eb.build();
  }
}
