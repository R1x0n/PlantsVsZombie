package com.supsi.frontend.factories.sun;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.sun.FixedSunComponent;
import com.supsi.frontend.components.sun.SunComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class SunFactory implements EntityFactory {
    @Spawns("sunFromSky")
    public Entity newSunFromSky(SpawnData data) {
        return entityBuilder(data)
                .type(SunTypes.SUN)
                .with(new SunComponent())
                .build();
    }

    @Spawns("sunFromSunflower")
    public Entity newSunFromSunflower(SpawnData data) {
        return entityBuilder(data)
                .type(SunTypes.SUN)
                .with(new FixedSunComponent())
                .build();
    }
}
