package com.supsi.frontend.components.projectile;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.component.Component;
import com.supsi.backend.commands.HitZombieCommand;
import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.zombies.Zombie;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BasicProjectileComponent extends Component {

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

    public void hitZombie(Zombie zombie) {
        entity.removeFromWorld();
        Command command = new HitZombieCommand(zombie);
        command.execute();
    }

    @Override
    public void onAdded() {
        var view = new Circle(BasicProjectileComponent.getV(), BasicProjectileComponent.getV1(), BasicProjectileComponent.getV2(), Color.RED);
        entity.getViewComponent().addChild(view);
        entity.addComponent(movementComponent);
    }

    @Override
    public void onUpdate(double tpf) {
        if (entity.getX() > FXGL.getGameScene().getWidth())
            entity.removeFromWorld();
    }
}
