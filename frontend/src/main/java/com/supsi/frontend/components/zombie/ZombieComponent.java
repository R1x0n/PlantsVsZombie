package com.supsi.frontend.components.zombie;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.commands.ZombieEatCommand;
import com.supsi.backend.model.plants.Plant;
import com.supsi.backend.model.zombies.Zombie;

import com.supsi.backend.state.Game;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;


public abstract class ZombieComponent extends Component {
    private final Zombie zombie;
    private final Component movementComponent;
    private TimerAction timerAction;

    public static int getWidth() {
        return 30;
    }

    public static int getHeight() {
        return 60;
    }

    public ZombieComponent(Zombie zombie) {
        this.zombie = zombie;
        this.movementComponent = new ProjectileComponent(new Point2D(-1, 0), 100 * zombie.getSpeed());
    }

    public void eating(Plant plant) {
        movementComponent.pause();
        var command = new ZombieEatCommand(zombie, plant);

        timerAction = getGameTimer().runAtInterval(() -> {
            if (!plant.isAlive()) {
                movementComponent.resume();
                timerAction.expire();
            }

            command.execute();
        }, Duration.millis(500));
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
