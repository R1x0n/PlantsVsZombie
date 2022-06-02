package com.supsi.frontend.components.plant;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.model.others.Configs;
import com.supsi.backend.model.plants.Sunflower;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;
import static java.lang.Math.*;

public class SunflowerComponent extends PlantComponent {

    private TimerAction timerAction;
    private final String textureName = "Sun_Plant.png";

    public SunflowerComponent() {
        super(new Sunflower());
    }

    @Override
    protected Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture(textureName);
        node.setScaleX(0.45);
        node.setScaleY(0.45);
        node.setLayoutY(-55);
        node.setLayoutX(-60);
        return node;
    }

    @Override
    public Node getTextureSelector() {
        Node nodeImage = FXGL.getAssetLoader().loadTexture(textureName);
        nodeImage.setLayoutY(-30);
        nodeImage.setLayoutX(-20);
        nodeImage.setViewOrder(-1);
        nodeImage.setScaleX(0.4);
        nodeImage.setScaleY(0.4);
        return nodeImage;
    }

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(getTextureNode());
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
