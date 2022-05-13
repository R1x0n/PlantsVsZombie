package com.supsi.frontend.factories.projectile;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.projectile.BasicProjectile;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class ProjectileFactory implements EntityFactory {

    @Spawns("projectile")
    public Entity newNormalProjectile(SpawnData data) {
        return entityBuilder(data)
                .type(ProjectileTypes.PROJECTILE_NORMAL)
                .viewWithBBox(new Circle(BasicProjectile.getV(), BasicProjectile.getV1(), BasicProjectile.getV2(), Color.TRANSPARENT))
                .with(new BasicProjectile())
                .collidable()
                .build();
    }
}
