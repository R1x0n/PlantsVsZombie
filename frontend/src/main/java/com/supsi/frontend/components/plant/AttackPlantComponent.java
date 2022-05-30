package com.supsi.frontend.components.plant;

import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.model.plants.AttackPlant;
import com.supsi.frontend.factories.zombie.ZombieTypes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class AttackPlantComponent extends PlantComponent<Rectangle> {
    private TimerAction timerAction;

    public AttackPlantComponent() {
        super(new AttackPlant());
        var shape = new Rectangle(super.getWidth(), super.getHeight(), Color.RED);
        super.setShape(shape);
    }

    @Override
    public void onAdded() {
        super.onAdded();
        timerAction = getGameTimer().runAtInterval(() -> {
            var zombies = getGameWorld().getEntitiesByType(ZombieTypes.ZOMBIE);
            var isThereAnyZombie = zombies.stream().anyMatch(zombie -> {
                var lowerBound = zombie.getY() - zombie.getHeight() / 2;
                var upperBound = zombie.getY() + zombie.getHeight() / 2;
                return lowerBound <= entity.getY() && upperBound >= entity.getY();
            });

            if (isThereAnyZombie)
                spawn("projectile", entity.getX(), entity.getY() + 20);
        }, Duration.millis(1250));
    }

    @Override
    public void onRemoved() {
        super.onRemoved();
        timerAction.expire();
    }

    @Override
    public String getFactoryId() {
        return "attack_plant";
    }
}
