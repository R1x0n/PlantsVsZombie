package com.supsi.frontend.factories.plant;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.plant.AttackPlantComponent;
import com.supsi.frontend.components.plant.DefensePlantComponent;
import com.supsi.frontend.components.plant.PlantComponent;
import com.supsi.frontend.components.plant.SunflowerComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class PlantFactory implements EntityFactory {
  private final Rectangle collisionBox = new Rectangle(PlantComponent.getWidth(), PlantComponent.getHeight(), Color.TRANSPARENT);

  @Spawns("sunflower")
  public Entity newSunflower(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.PLANT)
            .with(new SunflowerComponent())
            .viewWithBBox(collisionBox)
            .collidable()
            .build();
  }

  @Spawns("defense_plant")
  public Entity newDefensePlant(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.PLANT)
            .with(new DefensePlantComponent())
            .viewWithBBox(collisionBox)
            .collidable()
            .build();
  }

  @Spawns("attack_plant")
  public Entity newAttackPlant(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.PLANT)
            .with(new AttackPlantComponent())
            .viewWithBBox(collisionBox)
            .collidable()
            .build();
  }
}
