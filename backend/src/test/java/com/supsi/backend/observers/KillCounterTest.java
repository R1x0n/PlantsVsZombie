package com.supsi.backend.observers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KillCounterTest {

    @Test
    void getInstance() {
        KillCounter killCounter1 = KillCounter.getInstance();
        KillCounter killCounter2 = KillCounter.getInstance();
        assertNotNull(killCounter1);
        assertEquals(killCounter1, killCounter2);
    }

    @Test
    void getState() {
        KillCounter killCounter = new KillCounter();
        assertEquals(0, killCounter.getState());
    }

    @Test
    void add() {
        KillCounter killCounter = new KillCounter();
        killCounter.add();
        assertEquals(1, killCounter.getState());
    }
}