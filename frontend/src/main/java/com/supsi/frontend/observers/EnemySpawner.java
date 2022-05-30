package com.supsi.frontend.observers;

import com.almasb.fxgl.time.TimerAction;
import com.supsi.backend.observers.SpawnRate;
import com.supsi.backend.observers.utils.Observer;
import com.supsi.frontend.factories.zombie.ZombieFactory;

import java.util.Random;

import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

public class EnemySpawner implements Observer {
  private TimerAction enemySpawnerTimer;
  private final SpawnRate spawnRate = SpawnRate.getInstance();

  public EnemySpawner() {
    spawnRate.attach(this);
  }

  public void start(Duration spawnInterval) {
    // y positions of zombies to spawn - 60 for the collision box
    int[] zombieSpawnPositions = {220, 320, 420, 520, 620};
    Random random = new Random();

    enemySpawnerTimer = run(() -> {
      double x = getAppWidth() + 30; // + 30 = shape init outside of screen
      var selectedZombie = ZombieFactory.zombies[random.nextInt(ZombieFactory.zombies.length)];
      var selectedPosition = zombieSpawnPositions[random.nextInt(zombieSpawnPositions.length)];
      spawn(selectedZombie, x, selectedPosition);
    }, spawnInterval);
  }

  @Override
  public void update() {
    if (enemySpawnerTimer == null) return;

    enemySpawnerTimer.expire();
    start(Duration.seconds(spawnRate.getState()));
  }
}
