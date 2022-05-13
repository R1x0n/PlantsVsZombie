package com.supsi.backend.model.plants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePlant extends Plant {
  public ConcretePlant() {
    super(100, 0, 0, 0);
  }
}

class PlantTest {

  @Test
  void getHealth() {
    Plant plant = new ConcretePlant();
    assertEquals(100, plant.getHealth());
  }

  @Test
  void addHealth() {
    Plant plant = new ConcretePlant();
    plant.addHealth(10);
    assertEquals(110, plant.getHealth());

    plant.addHealth(-10);
    assertEquals(120, plant.getHealth());
  }

  @Test
  void takeDamage() {
    Plant plant = new ConcretePlant();
    plant.takeDamage(10);
    assertEquals(90, plant.getHealth());

    plant.takeDamage(-10);
    assertEquals(80, plant.getHealth());
  }

  @Test
  void isAlive() {
    Plant plant = new ConcretePlant();
    assertTrue(plant.isAlive());

    plant.takeDamage(100);
    assertFalse(plant.isAlive());
  }
}
