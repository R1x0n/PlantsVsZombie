package com.supsi.frontend.observers;

import com.supsi.backend.observers.KillCounter;
import com.supsi.backend.observers.utils.Observer;

public class KillCounterObserver implements Observer {

    private final KillCounter killcounter;
    public int counter;

    public KillCounterObserver() {
        killcounter = KillCounter.getInstance();
        killcounter.attach(this);
        this.counter = killcounter.getState();
    }

    @Override
    public void update() {
        this.counter = killcounter.getState();
    }
}
