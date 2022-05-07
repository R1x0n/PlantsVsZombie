package com.supsi.frontend.components.plant;

import com.supsi.backend.model.plants.Sunflower;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SunflowerComponent extends PlantComponent<Rectangle> {
  public SunflowerComponent() {
    super(new Sunflower());
    var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.YELLOW);
    super.setShape(shape);
  }

  @Override
  public String getFactoryId() {
    return "sunflower";
  }
}
