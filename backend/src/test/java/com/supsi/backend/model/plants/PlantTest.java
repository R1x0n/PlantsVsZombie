package com.supsi.backend.model.plants;

import com.supsi.backend.state.plant.PlantChargingState;
import com.supsi.backend.state.plant.PlantReadyState;
import com.supsi.backend.state.plant.PlantStateType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePlant extends Plant {
  public ConcretePlant() {
    super(100, 0, 0, 0, 1000);
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

  @Test
  void getRechargeTime() {
    Plant plant = new ConcretePlant();
    assertEquals(1000, plant.getRechargeTime());
  }

  @Test
  void setState() {
    Plant plant = new ConcretePlant();
    plant.setState(new PlantReadyState());
    assertEquals(PlantStateType.READY, plant.getState());
  }

  @Test
  void setReady() {
    Plant plant = new ConcretePlant();
    plant.setReady();
    assertEquals(PlantStateType.READY, plant.getState());
  }

  @Test
  void recharge() {
    Plant plant = new ConcretePlant();
    plant.setReady();
    plant.setCharging();
    assertEquals(PlantStateType.CHARGING, plant.getState());
  }

  @Test
  void getStatus() {
    Plant plant = new ConcretePlant();
    assertEquals(PlantStateType.READY, plant.getState());
  }

  @Test
  void catchException() {
    Plant plant = new ConcretePlant();
    PlantReadyState state = new PlantReadyState();
    assertThrows(UnsupportedOperationException.class, () -> state.setReady(plant));
    PlantChargingState state2 = new PlantChargingState();
    assertThrows(UnsupportedOperationException.class, () -> state2.setCharging(plant));
  }
}
