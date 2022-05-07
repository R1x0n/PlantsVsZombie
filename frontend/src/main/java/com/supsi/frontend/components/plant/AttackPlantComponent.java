package com.supsi.frontend.components.plant;

import com.supsi.backend.model.plants.AttackPlant;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AttackPlantComponent extends PlantComponent<Rectangle> {
  public AttackPlantComponent() {
    super(new AttackPlant());
    var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.RED);
    super.setShape(shape);
  }

  @Override
  public String getFactoryId() {
    return "attack_plant";
  }
}
