package com.supsi.backend.observers.utils;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Subject implements ISubject {
  private final ConcurrentLinkedQueue<Observer> observers;

  protected Subject() {
    this.observers = new ConcurrentLinkedQueue<>();
  }

  @Override
  public void attach(Observer o) {
    if (!this.observers.contains(o)) {
      this.observers.add(o);
    }
  }

  @Override
  public void detach(Observer o) {
    this.observers.remove(o);
  }

  @Override
  public void notifyObservers() {
    this.observers.forEach(Observer::update);
  }

  public ConcurrentLinkedQueue<Observer> getObservers(){
    return this.observers;
  }
}
