package com.supsi.frontend.components.zombie;

import com.almasb.fxgl.dsl.FXGL;
import com.supsi.backend.model.zombies.TankZombie;
import javafx.scene.Node;

public class TankZombieComponent extends ZombieComponent {

    private final String textureName = "Tank_Zombie.png";

    public TankZombieComponent() {
        super(new TankZombie());
    }

    @Override
    protected Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture(textureName);
        node.setRotate(180);
        node.setScaleX(0.60);
        node.setScaleY(0.60);
        node.setLayoutY(-55);
        node.setLayoutX(-45);
        return node;
    }
}
