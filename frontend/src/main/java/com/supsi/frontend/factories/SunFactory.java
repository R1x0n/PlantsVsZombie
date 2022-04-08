package com.supsi.frontend.factories;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.SunComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class SunFactory implements EntityFactory {
    @Spawns("sun")
    public Entity newSun(SpawnData data) {
        return entityBuilder(data)
                .type(EntityTypes.SUN)
                .collidable()
                .with(new SunComponent())
                .onClick(Entity::removeFromWorld)
                .build();
    }
}
