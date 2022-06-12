package com.supsi.frontend.factories.hud.pauseButton;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.hud.pauseButton.PauseButtonComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class PauseButtonFactory implements EntityFactory {

    @Spawns("pauseButton")
    public Entity newSelectorGrid(SpawnData data) {
        return entityBuilder(data)
                .type(PauseButtonTypes.NORMAL)
                .zIndex(1)
                .with(new PauseButtonComponent())
                .build();
    }
}
