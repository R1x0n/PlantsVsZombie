package com.supsi.frontend.observers;

import com.supsi.backend.observers.KillCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KillCounterObserverTest {

    @Test
    void update() {
        KillCounter killCounter = KillCounter.getInstance();
        KillCounterObserver observer = new KillCounterObserver();
        assertEquals(0, observer.counter);
        killCounter.add();
        assertEquals(1, observer.counter);
    }
}