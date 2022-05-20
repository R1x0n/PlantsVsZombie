package com.supsi.frontend.components.lawnmower;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.commands.CutZombieCommand;
import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.lawnmower.Lawnmower;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LawnmowerComponent extends Component {

    private final Command zombieCutCommand;
    public static int getWidth() {
        return 50;
    }

    public static int getHeight() {
        return 50;
    }

    private final Component movementComponent = new ProjectileComponent(new Point2D(1, 0), 300);

    public LawnmowerComponent() {
        zombieCutCommand = new CutZombieCommand(new Lawnmower()) ;
    }

    public void resumeMovement() {
        movementComponent.resume();
    }

    @Override
    public void onAdded() {
        var view = new Rectangle(getWidth(), getHeight(), Color.BLACK);
        movementComponent.pause();
        entity.getViewComponent().addChild(view);
        entity.addComponent(movementComponent);
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getX() > FXGL.getGameScene().getWidth()) {
            entity.removeFromWorld();
        }
    }

    public void cutZombie(LawnmowerComponent lawnmowerComponent, Entity zombie) {
        zombie.removeFromWorld();
        lawnmowerComponent.resumeMovement();
        zombieCutCommand.execute();
    }
}
