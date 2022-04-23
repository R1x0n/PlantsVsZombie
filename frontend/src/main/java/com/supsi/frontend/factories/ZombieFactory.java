package com.supsi.frontend.factories;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.supsi.frontend.components.zombie.NormalZombieComponent;
import com.supsi.frontend.components.zombie.RunnerZombieComponent;
import com.supsi.frontend.components.zombie.TankZombieComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class ZombieFactory implements EntityFactory {
  public static String[] zombies = {"zombie_tank", "zombie_runner", "zombie_normal"};

  @Spawns("zombie_tank")
  public Entity newZombieTank(SpawnData data) {
    return entityBuilder(data)
            .type(EntityTypes.ZOMBIE_TANK)
            .with(new TankZombieComponent())
            .collidable()
            .build();
  }

  @Spawns("zombie_normal")
  public Entity newZombie(SpawnData data) {
    return entityBuilder(data)
            .type(EntityTypes.ZOMBIE_NORMAL)
            .with(new NormalZombieComponent())
            .collidable()
            .build();
  }

  @Spawns("zombie_runner")
  public Entity newZombieRunner(SpawnData data) {
    return entityBuilder(data)
            .type(EntityTypes.ZOMBIE_RUNNER)
            .with(new RunnerZombieComponent())
            .collidable()
            .build();
  }
}
