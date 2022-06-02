package com.supsi.frontend.components.plant;

import com.almasb.fxgl.dsl.FXGL;
import com.supsi.backend.model.plants.DefensePlant;

import javafx.scene.Node;

public class DefensePlantComponent extends PlantComponent {

    private final String textureName = "Defense_Plant.png";

    public DefensePlantComponent() {
        super(new DefensePlant());
    }

    @Override
    protected Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture(textureName);
        node.setScaleX(0.4);
        node.setScaleY(0.4);
        node.setLayoutY(-50);
        node.setLayoutX(-50);
        return node;
    }

    @Override
    public Node getTextureSelector() {
        Node nodeImage = FXGL.getAssetLoader().loadTexture(textureName);
        nodeImage.setLayoutY(-35);
        nodeImage.setLayoutX(-20);
        nodeImage.setViewOrder(-1);
        nodeImage.setScaleX(0.35);
        nodeImage.setScaleY(0.35);
        return nodeImage;
    }

    @Override
    public void onAdded() {
        super.onAdded();
        entity.getViewComponent().addChild(getTextureNode());
    }

    @Override
    public String getFactoryId() {
        return "defense_plant";
    }
}
