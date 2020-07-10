package org.rest.service.swipe.common;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;

public class Dungeoneer {

  private User user;
  private Guild guild;
  private String gamertag;
  private int level;
  private int power;
  private DungeonDifficulties difficulty;
  private int partySize;
  private boolean inQueue = false;

  public Dungeoneer(final User user, final Guild guild, final String gamertag, final int level,
      final int power, final DungeonDifficulties difficulty, final int partySize) {

    this.user = user;
    this.gamertag = gamertag;
    this.level = level;
    this.power = power;
    this.difficulty = difficulty;
    this.partySize = partySize;
    this.guild = guild;
  }

  public Guild getGuild() {
    return guild;
  }

  public void setGuild(Guild guild) {
    this.guild = guild;
  }


  public boolean isInQueue() {
    return inQueue;
  }

  public void setInQueue(boolean inQueue) {
    this.inQueue = inQueue;
  }

  public int getPartySize() {
    return partySize;
  }

  public void setPartySize(int partySize) {
    this.partySize = partySize;
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getGamertag() {
    return gamertag;
  }

  public void setGamertag(String gamertag) {
    this.gamertag = gamertag;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getPower() {
    return power;
  }

  public void setPower(int power) {
    this.power = power;
  }

  public DungeonDifficulties getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(DungeonDifficulties difficulty) {
    this.difficulty = difficulty;
  }

  @Override
  public String toString() {
    return this.user.getName();
  }

  @Override
  public boolean equals(Object o) {
    return ((Dungeoneer) o).getUser().getName().equals(this.getUser().getName());
  }
}
