package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;
import com.supsi.backend.observers.Points;

import java.util.Timer;
import java.util.TimerTask;

public class Sunflower extends Plant {
  private final Points points = Points.getInstance();

  public Sunflower() {
    super(100, 0, 1, Configs.getInstance().getSunflowerCost(), 10000);
  }

  private void generatePoints() {
    // Add 50 points every 2s
    new Timer().scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        points.add(50);
      }
    }, 0, 2000);
  }
}
