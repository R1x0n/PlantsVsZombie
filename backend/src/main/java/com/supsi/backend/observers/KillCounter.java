package com.supsi.backend.observers;

import com.supsi.backend.observers.utils.Subject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class KillCounter extends Subject {

    private static final AtomicReference<KillCounter> instance = new AtomicReference<>();
    private final AtomicInteger killed = new AtomicInteger();

    public static KillCounter getInstance() {
        instance.compareAndSet(null, new KillCounter());
        return instance.get();
    }

    protected KillCounter() {
        super();
        this.killed.set(0);
    }

    public int getState() {
        return killed.get();
    }

    private void setState(int newPoints) {
        this.killed.set(newPoints);
        super.notifyObservers();
    }

    public void add() {
        this.killed.addAndGet(1);
        super.notifyObservers();
    }

    public void remove() {
        this.killed.addAndGet(-1);
        super.notifyObservers();
    }

    public void reset() {
        this.setState(0);
        super.notifyObservers();
    }
}
