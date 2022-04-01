package com.supsi.pvz.observers;

import com.supsi.pvz.observers.utils.Subject;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Subject that keeps track of the points of the player.
 * Thread-safe.
 */
public class Points extends Subject {
  private static final AtomicReference<Points> instance = new AtomicReference<>();
  private final AtomicInteger points = new AtomicInteger();

  public static Points getInstance() {
    instance.compareAndSet(null, new Points());
    return instance.get();
  }

  protected Points() {
    super();
    this.points.set(0);
  }

  public int getState() {
    return points.get();
  }

  public void setState(int newPoints) {
    this.points.set(newPoints);
    super.notifyObservers();
  }

  public void add(int newPoints) {
    this.points.addAndGet(newPoints);
    super.notifyObservers();
  }

  public void remove(int newPoints) {
    if (this.points.get() - newPoints < 0) {
      this.points.set(0);
    } else {
      this.points.addAndGet(-newPoints);
    }

    super.notifyObservers();
  }
}
