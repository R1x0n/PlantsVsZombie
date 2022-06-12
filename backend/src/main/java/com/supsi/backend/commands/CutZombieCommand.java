package com.supsi.backend.commands;

import com.supsi.backend.commands.utils.Command;
import com.supsi.backend.model.lawnmower.Lawnmower;
import com.supsi.backend.observers.KillCounter;

public class CutZombieCommand implements Command {
    static private final KillCounter killCounter = KillCounter.getInstance();

    public CutZombieCommand(Lawnmower lawnmower) {
    }

    @Override
    public void execute() {
        killCounter.add();
    }

    @Override
    public void undo() {
        killCounter.remove();
    }
}
