package com.supsi.frontend.components.projectile;


import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BasicProjectile extends Component {

    private final Component movementComponent = new ProjectileComponent(new Point2D(1, 0), 200);

    public static int[] getValues() {
        return new int[]{5, 3, 8};
    }

    public static int getV() {
        return getValues()[0];
    }

    public static int getV1() {
        return getValues()[1];
    }

    public static int getV2() {
        return getValues()[2];
    }

    @Override
    public void onAdded() {
        var view = new Circle(BasicProjectile.getV(), BasicProjectile.getV1(), BasicProjectile.getV2(), Color.RED);
        entity.getViewComponent().addChild(view);
        entity.addComponent(movementComponent);
    }
}
