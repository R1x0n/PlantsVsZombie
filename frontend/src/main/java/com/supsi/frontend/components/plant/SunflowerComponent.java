package com.supsi.frontend.components.plant;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.model.others.Configs;
import com.supsi.backend.model.plants.Sunflower;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;
import static java.lang.Math.*;

public class SunflowerComponent extends PlantComponent<Rectangle> {

  private TimerAction timerAction;

  public SunflowerComponent() {
    super(new Sunflower());
    var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.YELLOW);
    super.setShape(shape);
  }

  @Override
  public void onAdded() {
    super.onAdded();
    timerAction = getGameTimer().runAtInterval(() -> {
      Point2D point = computeSpawnPoint();
      spawn("sunFromSunflower", point.getX(), point.getY());
    }, Duration.millis(Configs.getInstance().getSunGenerationTimeInMilliseconds()));
  }

  @Override
  public void onRemoved() {
    super.onRemoved();
    timerAction.expire();
  }

  @Override
  public String getFactoryId() {
    return "sunflower";
  }

  private Point2D computeSpawnPoint() {
    int radius = FXGLMath.random(70, 80);
    int y = (int) pow(-1, FXGLMath.random(1, 3)) * FXGLMath.random(0, radius);
    int x = (int) (pow(-1, FXGLMath.random(1, 3)) * (sqrt(pow(radius, 2) - pow(y, 2))));
    return new Point2D(entity.getX() + getWidth() / 2 + x, entity.getY() + getHeight() / 2 + y);
  }
}
