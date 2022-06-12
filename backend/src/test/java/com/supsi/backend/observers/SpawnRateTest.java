package com.supsi.backend.observers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpawnRateTest {

  private final KillCounter killCounter = KillCounter.getInstance();
  private final SpawnRate spawnRate = SpawnRate.getInstance();

  @BeforeEach
  void setUp() {
    killCounter.reset();
  }

  @Test
  void getInstance() {
    SpawnRate instance2 = SpawnRate.getInstance();
    assertEquals(spawnRate, instance2);
  }

  @Test
  void getState() {
    assertEquals(spawnRate.getState(), 5.0);
  }

  @Test
  void update() {
    killCounter.add();
    assertEquals(spawnRate.getState(), 3.7750000000000004);
  }
}
