package org.rest.service.swipe.common;

public enum DungeonLevelGroups {
  FIVE(5), TEN(10), FIFTEEN(15), TWENTY(20), TWENTY_FIVE(25), THIRTY(30), THIRTY_FIVE(35), FORTY(
      40), FORTY_FIVE(45), FIFTY(50), FIFTY_FIVE(55);

  private final int level;

  private DungeonLevelGroups(int level) {
    this.level = level;
  }

  static DungeonLevelGroups valueOf(int group) {
    if (group == 5)
      return FIVE;
    if (group == 10)
      return TEN;
    if (group == 15)
      return FIFTEEN;
    if (group == 20)
      return TWENTY;
    if (group == 25)
      return TWENTY_FIVE;
    if (group == 30)
      return THIRTY;
    if (group == 35)
      return THIRTY_FIVE;
    if (group == 40)
      return FORTY;
    if (group == 45)
      return FORTY_FIVE;
    if (group == 50)
      return FIFTY;
    if (group == 55)
      return FIFTY_FIVE;

    return null;
  }
}
