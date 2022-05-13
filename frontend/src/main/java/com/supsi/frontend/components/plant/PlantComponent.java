package com.supsi.frontend.components.plant;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.model.plants.Plant;

import javafx.scene.Node;

public abstract class PlantComponent<T> extends Component {
  private final Plant plant;
  private T shape = null;

  public PlantComponent(Plant plant) {
    this.plant = plant;
  }

  @Override
  public void onAdded() {
    entity.getViewComponent().addChild((Node) shape);
  }

  @Override
  public void onUpdate(double tpf) {
    if (!plant.isAlive())
      entity.removeFromWorld();
  }

  protected void setShape(T shape) {
    this.shape = shape;
  }

  public static double getWidth() {
    return 25;
  }

  public static double getHeight() {
    return 45;
  }

  public abstract String getFactoryId();

  public T getShape() {
    return shape;
  }

  public Plant getPlant() {
    return plant;
  }

  @Override
  public boolean equals(Object o) {
    return getClass() == o.getClass();
  }
}
