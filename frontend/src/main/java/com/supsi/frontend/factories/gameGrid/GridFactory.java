package com.supsi.frontend.factories.gameGrid;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.gameGrid.CellComponent;
import com.supsi.frontend.components.gameGrid.GridComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class GridFactory implements EntityFactory {
    @Spawns("gameGrid")
    public Entity newGameGrid(SpawnData data) {
        return entityBuilder(data)
                .type(GridTypes.GAMEGRID)
                .with(new GridComponent())
                .build();
    }

    @Spawns("cell")
    public Entity newCell(SpawnData data) {
        return entityBuilder(data)
                .type(GridTypes.CELL)
                .with(new CellComponent())
                .build();
    }
}
