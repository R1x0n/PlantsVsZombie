package com.supsi.frontend.components.hud.pauseButton;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PauseButtonComponent extends Component {

    private void onClick() {
        FXGL.getGameController().gotoGameMenu();
    }

    @Override
    public void onAdded() {
        var shape = new Rectangle(70, 70, Color.GRAY);
        Image image;
        try {
            image = new Image(new FileInputStream("frontend/src/main/resources/pausewood.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        shape.setFill(new ImagePattern(image));
        entity.getViewComponent().addChild(shape);
        shape.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> onClick());
    }

}
