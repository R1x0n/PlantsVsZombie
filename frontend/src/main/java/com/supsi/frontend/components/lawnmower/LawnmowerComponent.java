package com.supsi.frontend.components.lawnmower;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.commands.CutZombieCommand;
import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.lawnmower.Lawnmower;
import javafx.geometry.Point2D;
import javafx.scene.Node;

public class LawnmowerComponent extends Component {

    private final Command zombieCutCommand;

    public static int getWidth() {
        return 90;
    }

    public static int getHeight() {
        return 50;
    }

    private final Component movementComponent = new ProjectileComponent(new Point2D(1, 0), 300);

    public LawnmowerComponent() {
        zombieCutCommand = new CutZombieCommand(new Lawnmower());
    }

    public void resumeMovement() {
        movementComponent.resume();
    }

    private Node getTextureNode() {
        return FXGL.getAssetLoader().loadTexture("Lawn_Mower.png");
    }

    @Override
    public void onAdded() {
        movementComponent.pause();
        entity.addComponent(movementComponent);
        entity.getViewComponent().addChild(getTextureNode());
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getX() > FXGL.getGameScene().getWidth()) {
            entity.removeFromWorld();
        }
    }

    public void cutZombie(LawnmowerComponent lawnmowerComponent, Entity zombie) {
        lawnmowerComponent.resumeMovement();
        zombieCutCommand.execute();
    }
}
