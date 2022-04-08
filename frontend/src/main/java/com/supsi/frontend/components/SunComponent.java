package com.supsi.frontend.components;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.model.others.Sun;
import com.supsi.frontend.factories.EntityTypes;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class SunComponent extends Component {

    private final Sun sun;

    public SunComponent() {
        this.sun = new Sun();
    }

    static public void handleEventforCircle(Sun e) {
        e.addPoints(50);
    }

    @Override
    public void onAdded() {
        EventHandler<MouseEvent> circleMeHandler = e -> handleEventforCircle(sun);
        var view = new Circle(30, 3, 15, Color.GOLD);
        entity.getViewComponent().addChild(view);
        view.addEventHandler(MouseEvent.MOUSE_CLICKED, circleMeHandler);

        var movementComponent = new ProjectileComponent(new Point2D(0, 1), FXGLMath.random(50, 150));
        entity.addComponent(movementComponent);
    }

    @Override
    public void onUpdate(double tpf) {
        var enemiesThatExits = getGameWorld().getEntitiesFiltered(e -> e.isType(EntityTypes.SUN));
        for (var current : enemiesThatExits) {
            if (current.getY() > getAppHeight() - 5) {
                current.removeFromWorld();
            }
        }
    }
}
