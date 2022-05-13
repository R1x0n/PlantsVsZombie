package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.plants.Plant;
import com.supsi.backend.model.zombies.Zombie;

public class ZombieEatCommand implements Command {
  private Zombie zombie;
  private Plant plant;

  public ZombieEatCommand(Zombie zombie, Plant plant) {
    this.zombie = zombie;
    this.plant = plant;
  }

  @Override
  public void execute() {
    plant.takeDamage(zombie.getDamage());
  }

  @Override
  public void undo() {
    plant.addHealth(zombie.getDamage());
  }
}
