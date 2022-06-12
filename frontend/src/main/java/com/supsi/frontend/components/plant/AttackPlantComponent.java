package com.supsi.frontend.components.plant;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.model.plants.AttackPlant;
import com.supsi.frontend.factories.zombie.ZombieTypes;

import javafx.scene.Node;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class AttackPlantComponent extends PlantComponent {
    private TimerAction timerAction;
    private final String textureName = "Attack_Plant.png";

    public AttackPlantComponent() {
        super(new AttackPlant());
    }

    @Override
    protected Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture(textureName);
        node.setScaleX(0.4);
        node.setScaleY(0.4);
        node.setLayoutY(-80);
        node.setLayoutX(-50);
        return node;
    }

    @Override
    public Node getTextureSelector() {
        Node nodeImage = FXGL.getAssetLoader().loadTexture(textureName);
        nodeImage.setLayoutY(-65);
        nodeImage.setLayoutX(-20);
        nodeImage.setViewOrder(-1);
        nodeImage.setScaleX(0.3);
        nodeImage.setScaleY(0.3);
        return nodeImage;
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
        entity.getViewComponent().addChild(getTextureNode());
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
