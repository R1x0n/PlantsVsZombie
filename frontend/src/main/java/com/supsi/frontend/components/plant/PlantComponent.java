package com.supsi.frontend.components.plant;

import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.model.plants.Plant;

import javafx.scene.Node;

public abstract class PlantComponent extends Component {
    private final Plant plant;

    public PlantComponent(Plant plant) {
        this.plant = plant;
    }

    abstract protected Node getTextureNode();

    abstract public Node getTextureSelector();

    @Override
    public void onUpdate(double tpf) {
        if (!plant.isAlive())
            entity.removeFromWorld();
    }

    public static double getWidth() {
        return 25;
    }

    public static double getHeight() {
        return 45;
    }

    public abstract String getFactoryId();

    public Plant getPlant() {
        return plant;
    }

    @Override
    public boolean equals(Object o) {
        return getClass() == o.getClass();
    }
}
