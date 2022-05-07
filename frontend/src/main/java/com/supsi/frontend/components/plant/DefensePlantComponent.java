package com.supsi.frontend.components.plant;

import com.supsi.backend.model.plants.DefensePlant;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DefensePlantComponent extends PlantComponent<Rectangle> {
  public DefensePlantComponent() {
    super(new DefensePlant());
    var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.BLUE);
    super.setShape(shape);
  }

  @Override
  public String getFactoryId() {
    return "defense_plant";
  }
}
