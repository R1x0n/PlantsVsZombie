package com.supsi.frontend.factories.selectorGrid;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.selectorGrid.*;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class SelectorGridFactory implements EntityFactory {

    @Spawns("selectorGrid")
    public Entity newSelectorGrid(SpawnData data) {
        return entityBuilder(data)
                .type(SelectorGridTypes.SELECTORGRID)
                .zIndex(1)
                .with(new SelectorGridComponent())
                .build();
    }

    @Spawns("selectorCell")
    public Entity newSelectorCell(SpawnData data) {
        return entityBuilder(data)
                .type(SelectorGridTypes.SELECTORCELL)
                .zIndex(2)
                .with(new SelectorCellComponent())
                .build();
    }

    @Spawns("pointCell")
    public Entity newPointCell(SpawnData data) {
        return entityBuilder(data)
                .type(SelectorGridTypes.POINTCELL)
                .zIndex(2)
                .with(new PointsCellComponent())
                .build();
    }
}
