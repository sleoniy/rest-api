package org.rest.service.swipe.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class SmashUtil {

  private SmashUtil() {}


  private static boolean calibrate(boolean playerOne) {
    Robot robot;
    try {
      System.setProperty("java.awt.headless", "false");
      robot = new Robot();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (playerOne) {
        robot.keyPress(KeyEvent.VK_LEFT);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.keyPress(KeyEvent.VK_UP);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_UP);
      } else {
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_A);

        robot.keyPress(KeyEvent.VK_W);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_W);
      }

    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  public static boolean PlayersToCPU() throws InterruptedException {
    if (!calibrate(true))
      return false;

    Thread.sleep(1000);
    Robot robot;
    try {
      System.setProperty("java.awt.headless", "false");
      robot = new Robot();

      robot.keyPress(KeyEvent.VK_DOWN);
      Thread.sleep(371);
      robot.keyRelease(KeyEvent.VK_DOWN);

      robot.keyPress(KeyEvent.VK_RIGHT);
      Thread.sleep(90);
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.keyPress(KeyEvent.VK_X);
      Thread.sleep(100);
      robot.keyRelease(KeyEvent.VK_X);
      Thread.sleep(100);
      robot.keyPress(KeyEvent.VK_RIGHT);
      Thread.sleep(160);
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.keyPress(KeyEvent.VK_X);
      Thread.sleep(100);
      robot.keyRelease(KeyEvent.VK_X);

    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  public static boolean calibratePlayer1() throws InterruptedException {
    calibrate(true);
    Robot robot;
    try {
      System.setProperty("java.awt.headless", "false");
      robot = new Robot();

      Thread.sleep(500);

      robot.keyPress(KeyEvent.VK_Z);
      // Thread.sleep(65);
      Thread.sleep(100);
      robot.keyRelease(KeyEvent.VK_Z);

      robot.keyPress(KeyEvent.VK_DOWN);
      // Thread.sleep(65);
      Thread.sleep(310);
      robot.keyRelease(KeyEvent.VK_DOWN);

      robot.keyPress(KeyEvent.VK_RIGHT);
      Thread.sleep(50);
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.keyPress(KeyEvent.VK_X);
      Thread.sleep(50);
      robot.keyRelease(KeyEvent.VK_X);

    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }


  public static boolean calibratePlayer2() throws InterruptedException {
    calibrate(false);
    Thread.sleep(500);
    Robot robot;
    try {
      System.setProperty("java.awt.headless", "false");
      robot = new Robot();
      robot.keyPress(KeyEvent.VK_2);
      // Thread.sleep(65);
      Thread.sleep(100);
      robot.keyRelease(KeyEvent.VK_2);
      robot.keyPress(KeyEvent.VK_S);
      // Thread.sleep(110);
      Thread.sleep(310);
      robot.keyRelease(KeyEvent.VK_S);
      robot.keyPress(KeyEvent.VK_D);
      Thread.sleep(54);
      robot.keyRelease(KeyEvent.VK_D);
      robot.keyPress(KeyEvent.VK_1);
      Thread.sleep(50);
      robot.keyRelease(KeyEvent.VK_1);

    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }

  public static boolean startMatch() {
    Robot robot;
    try {
      System.setProperty("java.awt.headless", "false");
      robot = new Robot();

      Thread.sleep(500);

      robot.keyPress(KeyEvent.VK_ENTER);
      Thread.sleep(50);
      robot.keyRelease(KeyEvent.VK_ENTER);
      Thread.sleep(1000);
      robot.keyPress(KeyEvent.VK_ENTER);
      Thread.sleep(50);
      robot.keyRelease(KeyEvent.VK_ENTER);
    } catch (AWTException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return true;
  }
}
