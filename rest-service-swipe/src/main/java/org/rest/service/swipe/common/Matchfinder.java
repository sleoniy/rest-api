package org.rest.service.swipe.common;

import java.util.List;
import net.dv8tion.jda.core.utils.tuple.ImmutablePair;
import net.dv8tion.jda.core.utils.tuple.Pair;

public class Matchfinder extends Thread {

  private List<Dungeoneer> lfmQueue;
  private List<List<Dungeoneer>> lfgQueue;

  // pair of two possible level groups
  public Matchfinder(List<Dungeoneer> lfmQueue, List<List<Dungeoneer>> list) {
    // TODO Auto-generated constructor stub
    this.lfmQueue = lfmQueue;
    this.lfgQueue = list;
  }

  public void run() {
    // Go through LFM queue
    // For each player, check lfgQueue
    // Check every 5 seconds

    while (lfmQueue.size() > 0) {
      lfmQueue.forEach(player -> {
        int playerLevel = player.getLevel();

        final Pair<List<Dungeoneer>, List<Dungeoneer>> levelgroups =
            new ImmutablePair<List<Dungeoneer>, List<Dungeoneer>>(null, null);

      });
    }
  }
}
