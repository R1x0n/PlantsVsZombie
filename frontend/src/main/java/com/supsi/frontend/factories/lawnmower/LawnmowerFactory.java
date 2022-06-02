package com.supsi.frontend.factories.lawnmower;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.lawnmower.LawnmowerComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class LawnmowerFactory implements EntityFactory {
    private final Rectangle collisionBox = new Rectangle(LawnmowerComponent.getWidth(), LawnmowerComponent.getHeight(), Color.TRANSPARENT);

    @Spawns("lawnmower")
    public Entity newSunflower(SpawnData data) {
        return entityBuilder(data)
                .type(LawnmowerTypes.LAWNMOWER)
                .with(new LawnmowerComponent())
                .viewWithBBox(collisionBox)
                .collidable()
                .zIndex(0)
                .build();
    }
}
