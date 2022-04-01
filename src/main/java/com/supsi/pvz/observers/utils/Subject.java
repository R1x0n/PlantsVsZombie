package com.supsi.pvz.observers.utils;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Subject implements ISubject {
  private final ConcurrentLinkedQueue<Observer> observers;

  protected Subject() {
    this.observers = new ConcurrentLinkedQueue<>();
  }

  protected Subject(ArrayList<Observer> newObservers) {
    this.observers = new ConcurrentLinkedQueue<>(newObservers);
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
