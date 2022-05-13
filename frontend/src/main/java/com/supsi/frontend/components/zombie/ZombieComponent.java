package com.supsi.frontend.components.zombie;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.model.zombies.Zombie;

import com.supsi.backend.state.Game;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class ZombieComponent extends Component {
    private final Component movementComponent;

    public static int getWidth() {
        return 30;
    }

    public static int getHeight() {
        return 60;
    }

    public ZombieComponent(Zombie zombie) {
        this.movementComponent = new ProjectileComponent(new Point2D(-1, 0), 100 * zombie.getSpeed());
    }

    public Component getMovementComponent() {
        return movementComponent;
    }

    @Override
    public void onAdded() {
        var shape = new Rectangle(getWidth(), getHeight(), Color.GREEN);
        entity.getViewComponent().addChild(shape);
        entity.addComponent(movementComponent);
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getX() <= 264) {
            Game.getInstance().setGameOver();
        }
    }
}
