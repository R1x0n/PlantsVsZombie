package com.supsi.frontend.factories;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.GridComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class GridFactory implements EntityFactory {
    @Spawns("gameGrid")
    public Entity newGameGrid(SpawnData data) {
        return entityBuilder(data)
                .type(EntityTypes.GAMEGRID)
                .with(new GridComponent())
                .build();
    }
}