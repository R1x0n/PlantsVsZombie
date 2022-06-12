package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.others.Projectile;
import com.supsi.backend.model.zombies.Zombie;

public class HitZombieCommand implements Command {
  private Zombie zombie;
  private Projectile projectile = new Projectile();

  public HitZombieCommand(Zombie zombie) {
    this.zombie = zombie;
  }

  @Override
  public void execute() {
    zombie.takeDamage(projectile.getDamage());
  }

  @Override
  public void undo() {
    zombie.addHealth(projectile.getDamage());
  }
}
