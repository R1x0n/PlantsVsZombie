package com.supsi.frontend.components.zombie;

import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.commands.ZombieEatCommand;
import com.supsi.backend.model.plants.Plant;
import com.supsi.backend.model.zombies.Zombie;

import com.supsi.backend.state.game.Game;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameTimer;

public abstract class ZombieComponent extends Component {
    private final Zombie zombie;
    private final Component movementComponent;
    private String texture;
    private TimerAction timerAction;

    public static int getWidth() {
        return 30;
    }

    public static int getHeight() {
        return 60;
    }

    abstract protected Node getTextureNode();

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

    public Zombie getZombie() {
        return zombie;
    }

    @Override
    public void onAdded() {
        int row = (int) entity.getY();
        entity.addComponent(movementComponent);
        entity.getViewComponent().addChild(getTextureNode());
        super.onAdded();
        int totalDigits = (int) Math.log10(row);
        int firstDigit = row / (int) Math.pow(10, totalDigits);
        entity.setZIndex(firstDigit);
    }

    @Override
    public void onUpdate(double tpf) {
        if (!zombie.isAlive())
            entity.removeFromWorld();

        if (entity.getX() <= 200)
            Game.getInstance().setGameOver();
    }
}
