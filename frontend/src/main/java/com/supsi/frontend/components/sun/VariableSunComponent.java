package com.supsi.frontend.components.sun;

import com.almasb.fxgl.dsl.FXGL;

public class VariableSunComponent extends SunComponent {

  private final int finalY = FXGL.random(200, 700);

  @Override
  public void onUpdate(double tpf) {
    if (entity.getY() >= finalY) {
      movementComponent.pause();
      initDespawn();
    }
  }
}
