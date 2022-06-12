package com.supsi.backend.observers;

import com.supsi.backend.model.plants.Sunflower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectedPlantTest {

  @Test
  void getInstance() {
    SelectedPlant<Object> p1 = SelectedPlant.getInstance();
    SelectedPlant<Object> p2 = SelectedPlant.getInstance();
    assertEquals(p1, p2);
  }

  @Test
  void getState() {
    SelectedPlant<Object> p = new SelectedPlant<>();
    assertNull(p.getState());

    p.setState(new Sunflower());
    assertNotNull(p.getState());
    assertTrue(p.getState() instanceof Sunflower);
  }

  @Test
  void setState() {
    SelectedPlant<Object> p = new SelectedPlant<>();
    p.setState(Sunflower.class);
    assertNotNull(p.getState());
    assertEquals(Sunflower.class, p.getState());
  }
}
