package com.supsi.backend.observers;

import com.supsi.backend.observers.utils.Observer;
import com.supsi.backend.observers.utils.Subject;

import java.util.concurrent.atomic.AtomicReference;

public class SpawnRate extends Subject implements Observer {
  private static final AtomicReference<SpawnRate> instance = new AtomicReference<>();
  private final KillCounter killCounter = KillCounter.getInstance();
  private final AtomicReference<Double> spawnRate = new AtomicReference<>(0.0);

  private SpawnRate() {
    super();
    killCounter.attach(this);
  }

  public static SpawnRate getInstance() {
    instance.compareAndSet(null, new SpawnRate());
    return instance.get();
  }

  public double getState() {
    return spawnRate.get();
  }

  @Override
  public void update() {
    double maxSpawnTime = 5;
    double minSpawnTime = 0.1;
    double spawnTime = minSpawnTime + (maxSpawnTime - minSpawnTime)/((double) killCounter.getState()/3 + 1);
    spawnRate.set(spawnTime);
    super.notifyObservers();
  }
}
