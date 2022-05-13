package com.supsi.frontend.factories.zombie;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.zombie.NormalZombieComponent;
import com.supsi.frontend.components.zombie.RunnerZombieComponent;
import com.supsi.frontend.components.zombie.TankZombieComponent;
import com.supsi.frontend.components.zombie.ZombieComponent;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class ZombieFactory implements EntityFactory {
    public static String[] zombies = {"zombie_tank", "zombie_runner", "zombie_normal"};
    private final Rectangle collisionBox = new Rectangle(ZombieComponent.getWidth(), ZombieComponent.getHeight(), Color.TRANSPARENT);

    @Spawns("zombie_tank")
    public Entity newZombieTank(SpawnData data) {
        return entityBuilder(data)
                .type(ZombieTypes.ZOMBIE)
                .with(new TankZombieComponent())
                .viewWithBBox(collisionBox)
                .collidable()
                .build();
    }

    @Spawns("zombie_normal")
    public Entity newZombie(SpawnData data) {
        return entityBuilder(data)
                .type(ZombieTypes.ZOMBIE)
                .with(new NormalZombieComponent())
                .viewWithBBox(collisionBox)
                .collidable()
                .build();
    }

    @Spawns("zombie_runner")
    public Entity newZombieRunner(SpawnData data) {
        return entityBuilder(data)
                .type(ZombieTypes.ZOMBIE)
                .with(new RunnerZombieComponent())
                .viewWithBBox(collisionBox)
                .collidable()
                .build();
    }
}
