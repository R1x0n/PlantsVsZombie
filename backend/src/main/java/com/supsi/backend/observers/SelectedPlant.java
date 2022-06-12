package com.supsi.backend.observers;

import com.supsi.backend.observers.utils.Subject;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Subject that keeps track of the selected plant.
 * Thread-safe.
 */
public class SelectedPlant<T> extends Subject {
  private static final AtomicReference<SelectedPlant> instance = new AtomicReference<>();
  private final AtomicReference<T> plant = new AtomicReference<>();

  public static <T> SelectedPlant<T> getInstance() {
    instance.compareAndSet(null, new SelectedPlant<>());
    return instance.get();
  }

  protected SelectedPlant() {
    super();
    this.plant.set(null);
  }

  public T getState() {
    return plant.get();
  }

  public void setState(T plant) {
    this.plant.set(plant);
    super.notifyObservers();
  }
}
