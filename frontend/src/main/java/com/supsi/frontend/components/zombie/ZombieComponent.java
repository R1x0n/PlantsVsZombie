package com.supsi.frontend.components.zombie;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.state.Game;
import com.supsi.backend.model.zombies.Zombie;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public abstract class ZombieComponent extends Component {
    private final Zombie zombie;

    public ZombieComponent(Zombie zombie) {
        this.zombie = zombie;
    }

    @Override
    public void onAdded() {
        var shape = new Rectangle(30, 60, Color.GREEN);
        entity.getViewComponent().addChild(shape);

        var movementComponent = new ProjectileComponent(new Point2D(-1, 0), 100 * zombie.getSpeed());
        entity.addComponent(movementComponent);
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getX() <= 264) {
            Game.getInstance().setGameOver();
        }
    }
}
