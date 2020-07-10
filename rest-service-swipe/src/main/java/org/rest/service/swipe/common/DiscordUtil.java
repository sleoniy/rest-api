package org.rest.service.swipe.common;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
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

  public static MessageEmbed buildLFGMessage(final Guild guild, final int position,
      final Dungeoneer player) {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("Matchmaking", null);
    eb.setColor(Color.red);
    eb.setColor(new Color(0xF40C0C));
    eb.setColor(new Color(255, 0, 54));
    eb.setDescription("You are now in queue for finding a group!");
    eb.addField("Server:", guild.getName(), true);
    eb.addField("Status:", DungeoneerConstants.LFG, true);
    eb.addField("Gamertag:", player.getGamertag(), true);
    eb.addField("Level:", Integer.toString(player.getLevel()), true);
    eb.addField("Power:", Integer.toString(player.getPower()), true);
    eb.addField("Difficulty:", player.getDifficulty().toString(), true);
    eb.addField("Queue Position:", Integer.toString(position), false);

    return eb.build();
  }

  public static MessageEmbed buildLFMMessage(final Guild guild, final int position,
      final Dungeoneer player) {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("Matchmaking", null);
    eb.setColor(Color.red);
    eb.setColor(new Color(0xF40C0C));
    eb.setColor(new Color(255, 0, 54));
    eb.setDescription("You are now in queue for finding more members!");
    eb.addField("Server:", guild.getName(), true);
    eb.addField("Status:", DungeoneerConstants.LFM, true);
    eb.addField("Gamertag:", player.getGamertag(), true);
    eb.addField("Level:", Integer.toString(player.getLevel()), true);
    eb.addField("Power:", Integer.toString(player.getPower()), true);
    eb.addField("Difficulty:", player.getDifficulty().toString(), true);
    eb.addField("Queued Party Size:", Integer.toString(player.getPartySize()), false);
    eb.addField("Queue Position:", Integer.toString(position), false);
    return eb.build();
  }

  public static int getPowerGroup(final int level) {
    int group = level / 5;
    return group;

  }


  public static MessageEmbed buildMMErrorMessage(Guild guild, int size, Dungeoneer player) {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("ERROR", null);
    eb.setColor(Color.red);
    eb.setColor(new Color(0xF40C0C));
    eb.setColor(new Color(255, 0, 54));
    eb.setDescription("One of your parameters is invalid or you are already in queue!");
    return eb.build();
  }

  public static MessageEmbed buildErrorMessage() {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("ERROR - Already Signed Up!", null);
    eb.setColor(Color.red);
    eb.setColor(new Color(0xF40C0C));
    eb.setColor(new Color(255, 0, 54));
    eb.setDescription("You have already signed up as a member under this guild for Broker!");
    return eb.build();
  }

  public static MessageEmbed buildWalletMessage(final Player p) {
    final EmbedBuilder eb = new EmbedBuilder();
    eb.setTitle("Wallet", null);
    eb.setColor(Color.red);
    eb.setColor(new Color(0xF40C0C));
    eb.setColor(new Color(255, 0, 54));
    eb.addField("Credits:", p.getTokens(), true);
    return eb.build();
  }

  public static boolean addPlayer(final Map<String, Map<String, Player>> mapper,
      final Player player) throws IOException {
    final Writer fr;
    if (mapper.get(player.getGuild()).get(player.getUser()) == null)
      try {
        fr = new FileWriter(
            "C:\\Github\\rest-api\\rest-service-discord\\src\\main\\resources\\players.csv");
        final BufferedWriter writer = new BufferedWriter(fr);
        writer.write(player.toString() + "\n");
        writer.close();
        fr.close();
        return true;
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    return false;
  }

  private static boolean playerExists(final Player player) {
    return false;
  }
}
