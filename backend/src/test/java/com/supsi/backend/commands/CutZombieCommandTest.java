package com.supsi.backend.commands;

import com.supsi.backend.model.lawnmower.Lawnmower;
import com.supsi.backend.observers.KillCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutZombieCommandTest {

    @BeforeEach
    void reset() {
        KillCounter.getInstance().reset();
    }

    @Test
    void execute() {
        CutZombieCommand cutZombieCommand = new CutZombieCommand(new Lawnmower());
        cutZombieCommand.execute();
        KillCounter killCounter = KillCounter.getInstance();
        assertEquals(1, killCounter.getState());
    }

    @Test
    void undo() {
        CutZombieCommand cutZombieCommand = new CutZombieCommand(new Lawnmower());
        cutZombieCommand.undo();
        KillCounter killCounter = KillCounter.getInstance();
        assertEquals(-1, killCounter.getState());
    }
}