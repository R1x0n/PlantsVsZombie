package com.supsi.backend.model.lawnmower;

import com.supsi.backend.commands.CutZombieCommand;
import com.supsi.backend.commands.utils.Command;

public class Lawnmower {

    private final Command zombieCutCommand;

    public Lawnmower() {
        zombieCutCommand = new CutZombieCommand(this);
    }

    public void cutZombie() {
        zombieCutCommand.execute();
    }

    public void undoCutZombie() {
        zombieCutCommand.undo();
    }
}
