package com.supsi.frontend.components.plant;

import com.supsi.backend.model.plants.AttackPlant;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;

public class AttackPlantComponent extends PlantComponent<Rectangle> {
    public AttackPlantComponent() {
        super(new AttackPlant());
        var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.RED);
        super.setShape(shape);
    }

    @Override
    public void onAdded() {
        super.onAdded();
        getGameTimer().runAtInterval(() -> spawn("projectile", entity.getX(), entity.getY() + 20), Duration.millis(1000));
    }

    @Override
    public String getFactoryId() {
        return "attack_plant";
    }
}
