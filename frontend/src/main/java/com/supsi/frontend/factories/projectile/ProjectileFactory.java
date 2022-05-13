package com.supsi.frontend.factories.projectile;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.projectile.BasicProjectileComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class ProjectileFactory implements EntityFactory {

    @Spawns("projectile")
    public Entity newNormalProjectile(SpawnData data) {
        return entityBuilder(data)
                .type(ProjectileTypes.PROJECTILE_NORMAL)
                .viewWithBBox(new Circle(BasicProjectileComponent.getV(), BasicProjectileComponent.getV1(), BasicProjectileComponent.getV2(), Color.TRANSPARENT))
                .with(new BasicProjectileComponent())
                .collidable()
                .build();
    }
}
