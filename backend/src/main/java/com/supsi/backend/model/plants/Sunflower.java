package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;

public class Sunflower extends Plant {
  public Sunflower() {
    super(100, 0, 1, Configs.getInstance().getSunflowerCost(), 5000);
  }
}
