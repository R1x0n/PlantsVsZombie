package com.supsi.backend.model.lawnmower;

import com.supsi.backend.observers.KillCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnmowerTest {

    @BeforeEach
    void reset(){
       KillCounter.getInstance().reset();
    }

    @Test
    void cutZombie() {
        Lawnmower lawnmower = new Lawnmower();
        lawnmower.cutZombie();
        KillCounter killCounter = KillCounter.getInstance();
        assertEquals(1, killCounter.getState());
    }

    @Test
    void undoCutZombie() {
        Lawnmower lawnmower = new Lawnmower();
        lawnmower.cutZombie();
        KillCounter killCounter = KillCounter.getInstance();
        lawnmower.undoCutZombie();
        assertEquals(0, killCounter.getState());
    }
}
