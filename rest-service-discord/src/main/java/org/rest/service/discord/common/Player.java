package org.rest.service.discord.common;

public class Player {

  private String userId;
  private String guildId;
  private String tokens;

  public Player(final String userId, final String guildId, final String playerProperties) {

    this.userId = userId;
    this.tokens = playerProperties;
    this.guildId = guildId;
  }

  public String getTokens() {
    return tokens;
  }

  public void setTokens(String tokens) {
    this.tokens = tokens;
  }

  public String getGuild() {
    return guildId;
  }

  public void setGuild(String guild) {
    this.guildId = guild;
  }

  public String getUser() {
    return userId;
  }

  public void setUser(String user) {
    this.userId = user;
  }


  @Override
  public String toString() {
    return this.userId + "," + this.guildId + "," + this.getTokens();
  }

  @Override
  public boolean equals(Object o) {
    return ((Player) o).getUser().equals(this.getUser());
  }
}
