package com.supsi.backend;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

  @Test
  void randomCoordinate() {
    var res = Utils.randomCoordinate(200, 200);
    assertEquals(200, res);

    res = Utils.randomCoordinate(0, 0);
    assertEquals(0, res);

    res = Utils.randomCoordinate(0, 200);
    assertTrue(res >= 0 && res <= 200);

    res = Utils.randomCoordinate(-20, -10);
    assertTrue(res >= -20 && res <= -10);
  }
}
