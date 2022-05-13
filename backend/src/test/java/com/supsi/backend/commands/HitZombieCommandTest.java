package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.others.Configs;
import com.supsi.backend.model.zombies.NormalZombie;
import com.supsi.backend.model.zombies.Zombie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteZombie extends Zombie{
    ConcreteZombie() {
        super(100, 10,10);
    }
}

class HitZombieCommandTest {

    @Test
    void execute() {
        Zombie zombie = new ConcreteZombie();
        var currentHealth = zombie.getHealth();
        Command command = new HitZombieCommand(zombie);
        Configs configs = Configs.getInstance();
        command.execute();
        assertEquals(currentHealth - configs.getProjectileDamage(), zombie.getHealth());
    }

    @Test
    void undo() {
        Zombie zombie = new ConcreteZombie();
        Command command = new HitZombieCommand(zombie);
        command.execute();
        command.undo();
        assertEquals(100, zombie.getHealth());
    }
}