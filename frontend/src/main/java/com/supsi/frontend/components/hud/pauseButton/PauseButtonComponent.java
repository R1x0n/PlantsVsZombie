package com.supsi.frontend.components.hud.pauseButton;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PauseButtonComponent extends Component {

    private void onClick() {
        FXGL.getGameController().gotoGameMenu();
    }

    private Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture("PauseWood.png");
        node.setScaleX(0.3);
        node.setScaleY(0.3);
        node.setLayoutX(-195);
        node.setLayoutY(-155);
        node.setViewOrder(2);
        return node;
    }

    @Override
    public void onAdded() {
        var shape = new Rectangle(70, 70, Color.TRANSPARENT);
        entity.getViewComponent().addChild(shape);
        entity.getViewComponent().addChild(getTextureNode());
        shape.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> onClick());
    }

}
