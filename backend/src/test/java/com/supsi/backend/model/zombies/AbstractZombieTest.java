package com.supsi.backend.model.zombies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteZombie extends Zombie {
    public ConcreteZombie(int health, int damage, int speed) {
      super(health, damage, speed);
    }
}

class AbstractZombieTest {

  @Test
  void getHealth() {
    ConcreteZombie concreteZombie = new ConcreteZombie(10, 10, 10);
    assertEquals(10, concreteZombie.getHealth());
  }

  @Test
  void getSpeed() {
    ConcreteZombie concreteZombie = new ConcreteZombie(10, 10, 10);
    assertEquals(10, concreteZombie.getSpeed());
  }

  @Test
  void getDamage() {
    ConcreteZombie concreteZombie = new ConcreteZombie(10, 10, 10);
    assertEquals(10, concreteZombie.getDamage());
  }

  @Test
  void takeDamage() {
    ConcreteZombie concreteZombie = new ConcreteZombie(10, 10, 10);
    assertEquals(5, concreteZombie.takeDamage(5));
    assertEquals(0, concreteZombie.takeDamage(10));
  }
}
