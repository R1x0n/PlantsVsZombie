package com.supsi.frontend.components.plant;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.model.plants.Plant;

import javafx.scene.Node;

public abstract class PlantComponent<T> extends Component {
  private final Plant plant;
  private T shape = null;
  private final double width = 25;
  private final double height = 45;

  public PlantComponent(Plant plant) {
    this.plant = plant;
  }

  @Override
  public void onAdded() {
    entity.getViewComponent().addChild((Node) shape);
  }

  protected void setShape(T shape) {
    this.shape = shape;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public abstract String getFactoryId();

  public T getShape() {
    return shape;
  }

  public Plant getPlant() {
    return plant;
  }
}
