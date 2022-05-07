package com.supsi.frontend.factories.plant;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.plant.AttackPlantComponent;
import com.supsi.frontend.components.plant.DefensePlantComponent;
import com.supsi.frontend.components.plant.SunflowerComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class PlantFactory implements EntityFactory {
  @Spawns("sunflower")
  public Entity newSunflower(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.SUNFLOWER)
            .with(new SunflowerComponent())
            .collidable()
            .build();
  }

  @Spawns("defense_plant")
  public Entity newDefensePlant(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.DEFENSEPLANT)
            .with(new DefensePlantComponent())
            .collidable()
            .build();
  }

  @Spawns("attack_plant")
  public Entity newAttackPlant(SpawnData data) {
    return entityBuilder(data)
            .type(PlantTypes.ATTACKPLANT)
            .with(new AttackPlantComponent())
            .collidable()
            .build();
  }
}
