package com.supsi.frontend.components.sun;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.commands.SunClickedCommand;
import com.supsi.backend.Utils;
import com.supsi.backend.model.others.Sun;
import com.supsi.backend.commands.utils.Command;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SunComponent extends Component {

    private final Command sunClickedCommand;
    private final int finalY = Utils.randomCoordinate(200, 700);
    protected final Component movementComponent = new ProjectileComponent(new Point2D(0, 1), FXGLMath.random(50, 150));

    public SunComponent() {
        sunClickedCommand = new SunClickedCommand(new Sun());
    }

    private void onClick() {
        sunClickedCommand.execute();
        entity.removeFromWorld();
    }

    @Override
    public void onAdded() {
        var view = new Circle(30, 3, 15, Color.GOLD);
        entity.getViewComponent().addChild(view);
        entity.addComponent(movementComponent);

        view.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> onClick());
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getY() >= finalY)
            movementComponent.pause();
    }
}
