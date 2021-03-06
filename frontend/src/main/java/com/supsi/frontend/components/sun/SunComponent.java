package com.supsi.frontend.components.sun;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.commands.SunClickedCommand;
import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.others.Sun;

import java.util.Optional;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;

public abstract class SunComponent extends Component {

    private final Command sunClickedCommand;

    private final Sun sun = new Sun();

    protected final Component movementComponent = new ProjectileComponent(new Point2D(0, 1), FXGLMath.random(50, 150));

    public SunComponent() {
        sunClickedCommand = new SunClickedCommand(sun);
    }

    public void initDespawn() {
        Duration despawnTime = Duration.millis(sun.getDespawnTimeInMilliseconds());
        getGameTimer().runOnceAfter(() -> Optional.ofNullable(entity).ifPresent(Entity::removeFromWorld), despawnTime);
    }

    private Node getTextureNode() {
        Node node = FXGL.getAssetLoader().loadTexture("Sun.png");
        node.setScaleX(0.60);
        node.setScaleY(0.60);
        node.setLayoutY(-45);
        node.setLayoutX(-15);
        node.setViewOrder(1);
        return node;
    }

    private void onClick() {
        sunClickedCommand.execute();
        entity.removeFromWorld();
    }

    @Override
    public void onAdded() {
        var view = new Circle(35, 3, 15, Color.TRANSPARENT);
        entity.getViewComponent().addChild(view);
        entity.addComponent(movementComponent);
        entity.getViewComponent().addChild(getTextureNode());

        view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> onClick());
    }
}
