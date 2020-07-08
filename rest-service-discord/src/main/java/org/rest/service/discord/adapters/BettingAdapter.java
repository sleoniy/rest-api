package org.rest.service.discord.adapters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.rest.service.discord.common.DiscordUtil;
import org.rest.service.discord.common.Player;
import org.rest.service.discord.common.SmashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class BettingAdapter extends ListenerAdapter {

  private final static Logger logger = LoggerFactory.getLogger(BettingAdapter.class);
  private final Map<String, Map<String, Player>> mapper = new HashMap<>();

  @Override
  public void onReady(ReadyEvent event) {
    logger.info("Loading inventory...");
    FileReader fr;
    try {
      fr = new FileReader(
          "C:\\Github\\rest-api\\rest-service-discord\\src\\main\\resources\\players.csv");
      final BufferedReader reader = new BufferedReader(fr);
      String entry = reader.readLine();
      while (entry != null) {
        final String[] playerProperties = entry.split(",");
        final Player p = new Player(playerProperties[0], playerProperties[1], playerProperties[2]);
        mapper.putIfAbsent(playerProperties[1], new HashMap<>());
        mapper.get(playerProperties[1]).put(playerProperties[0], p);
        entry = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    logger.info("BettingAdapter has been initialized!");
  }


  @Override
  public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    final Member member = event.getMember();
    final String message = event.getMessage().getContentRaw();
    final String guildId = event.getGuild().getId();
    final String userId = member.getUser().getId();
    final Player p = mapper.get(guildId).get(userId);

    if (message == null || message.length() < 1)
      return;

    if (message.charAt(0) == '!') {
      if (message.equals("!wallet")) {
        event.getChannel().sendMessage(DiscordUtil.buildWalletMessage(p)).queue();
      } else if (message.contains("!join")) {
        String[] parameters = message.split(" ");
        String character = parameters[1];

      } else if (message.equals("!send")) {

      } else if (message.equals("!signup")) {
        final Player player = new Player(member.getUser().getId(), event.getGuild().getId(), "20");
        try {
          if (!DiscordUtil.addPlayer(mapper, player)) {
            member.getUser().openPrivateChannel().queue((channel) -> {
              channel.sendMessage(DiscordUtil.buildErrorMessage()).queue();
            });
            event.getMessage().delete().queue();
          }

          logger.info("Player added!");
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else if (message.contains("!reset")) {
        String[] parameters = message.split(" ");
        if (parameters[1].equals("1"))
          try {
            SmashUtil.calibratePlayer1();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        else if (parameters[1].equals("2"))
          try {
            SmashUtil.calibratePlayer2();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        else {
          try {
            SmashUtil.calibratePlayer1();
            SmashUtil.calibratePlayer2();
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      } else if (message.contains("!start")) {
        try {
          SmashUtil.PlayersToCPU();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        SmashUtil.startMatch();
      } else if (message.contains("!demo")) {
        try {
          SmashUtil.calibratePlayer1();
          SmashUtil.calibratePlayer2();
          SmashUtil.PlayersToCPU();
          SmashUtil.startMatch();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }


      } else if (message.contains("!flip")) {
        try {
          SmashUtil.PlayersToCPU();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }

}
