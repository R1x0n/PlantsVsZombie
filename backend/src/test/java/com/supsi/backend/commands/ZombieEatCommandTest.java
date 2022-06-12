package com.supsi.backend.commands;

import com.supsi.backend.model.plants.AttackPlant;
import com.supsi.backend.model.plants.Plant;
import com.supsi.backend.model.zombies.NormalZombie;
import com.supsi.backend.model.zombies.Zombie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZombieEatCommandTest {
  @Test
  void execute() {
    Plant plant = new AttackPlant();
    int currentHealth = plant.getHealth();
    Zombie zombie = new NormalZombie();
    ZombieEatCommand zombieEatCommand = new ZombieEatCommand(zombie, plant);
    zombieEatCommand.execute();
    assertEquals(plant.getHealth(), currentHealth - zombie.getDamage());
  }

  @Test
  void undo() {
    Plant plant = new AttackPlant();
    int currentHealth = plant.getHealth();
    Zombie zombie = new NormalZombie();
    ZombieEatCommand zombieEatCommand = new ZombieEatCommand(zombie, plant);
    zombieEatCommand.execute();
    zombieEatCommand.undo();
    assertEquals(currentHealth, plant.getHealth());
  }
}
