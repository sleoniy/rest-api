package org.rest.service.discord.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.rest.service.discord.common.DiscordUtil;
import org.rest.service.discord.common.DungeonDifficulties;
import org.rest.service.discord.common.Dungeoneer;
import org.rest.service.discord.common.DungeoneerConstants;
import org.rest.service.discord.common.Matchfinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class DungeoneerAdapter extends ListenerAdapter {

  private final static Logger logger = LoggerFactory.getLogger(DungeoneerAdapter.class);
  private final Map<Guild, List<List<Dungeoneer>>> lfg_queue = new HashMap<>();
  private final Map<Guild, List<Dungeoneer>> lfm_queue = new HashMap<>();
  private Matchfinder matchfinder;

  @Override
  public void onReady(ReadyEvent event) {
    logger.info("DungeoneerAdapter has been initialized!");
  }

  @Override
  public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
    final String message = event.getMessage().getContentRaw();
    final Member member = event.getMember();

    if (message == null || message.length() < 1)
      return;

    if (message.charAt(0) == '!') {
      // !LFG <gamertag> <level> <power> <difficulty>
      if (message.substring(1, 4).equals(DungeoneerConstants.LFG)) {
        // Notify user he has joined queue
        final String[] parameters = message.split(" ");

        if (parameters.length != 5)
          return;

        final Dungeoneer player = new Dungeoneer(member.getUser(), member.getGuild(), parameters[1],
            Integer.valueOf(parameters[2]), Integer.valueOf(parameters[3]),
            DungeonDifficulties.valueOf(parameters[4].toUpperCase()), 0);

        if (validCriteria(player) && !player.isInQueue()) {
          player.setInQueue(true);

          if (lfg_queue.get(event.getGuild()) == null) {
            // prepare server
            lfg_queue.put(member.getGuild(), new ArrayList<>());

            // Add a queue for every 5 levels
            for (int i = 0; i < 12; i++)
              lfg_queue.get(event.getGuild()).add(new ArrayList<>());

          }

          // Get level group and add player to it
          lfg_queue.get(event.getGuild()).get(DiscordUtil.getPowerGroup(player.getLevel()))
              .add(player);


          logger.info("User: " + member.getUser().getName() + " has been added to LFG for server: "
              + event.getGuild().getName());

          member.getUser().openPrivateChannel().queue((channel) -> {
            channel.sendMessage(DiscordUtil.buildLFGMessage(event.getGuild(),
                lfg_queue.get(event.getGuild()).size(), player)).queue();
          });

        } else {
          member.getUser().openPrivateChannel().queue((channel) -> {
            channel.sendMessage(DiscordUtil.buildMMErrorMessage(event.getGuild(),
                lfm_queue.get(event.getGuild()).size(), player)).queue();
          });
        }
        // !LFM <gamertag> <level> <power> <difficulty> <current party size>
      } else if (message.substring(1, 4).equals(DungeoneerConstants.LFM)) {
        // Notify user he has joined queue
        final String[] parameters = message.split(" ");

        if (parameters.length != 6)
          return;

        final Dungeoneer player = new Dungeoneer(member.getUser(), member.getGuild(), parameters[1],
            Integer.valueOf(parameters[2]), Integer.valueOf(parameters[3]),
            DungeonDifficulties.valueOf(parameters[4].toUpperCase()),
            Integer.valueOf(parameters[5]));

        if (validCriteria(player) && !player.isInQueue()) {
          player.setInQueue(true);
          if (lfm_queue.get(event.getGuild()) == null) {
            // prepare server
            lfm_queue.put(event.getGuild(), new ArrayList<>());

            if (matchfinder == null) {
              matchfinder =
                  new Matchfinder(lfm_queue.get(event.getGuild()), lfg_queue.get(event.getGuild()));
            }

          }

          // Get level group and add player to it
          lfm_queue.get(event.getGuild()).add(player);


          logger.info("User: " + member.getUser().getName() + " has been added to LFG for server: "
              + event.getGuild().getName());

          member.getUser().openPrivateChannel().queue((channel) -> {
            channel.sendMessage(DiscordUtil.buildLFMMessage(event.getGuild(),
                lfm_queue.get(event.getGuild()).size(), player)).queue();
          });

        } else {
          member.getUser().openPrivateChannel().queue((channel) -> {
            channel.sendMessage(DiscordUtil.buildMMErrorMessage(event.getGuild(),
                lfm_queue.get(event.getGuild()).size(), player)).queue();
          });
        }
      }
    }
  }

  private boolean validCriteria(final Dungeoneer player) {
    if (DungeonDifficulties.valueOf(player.getDifficulty().toString().toUpperCase()) == null)
      return false;

    if (player.getLevel() < 1) // || player.getLevel() > 55)
      return false;

    if (player.getGamertag().length() < 1)
      return false;

    return true;
  }
}
