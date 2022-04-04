package com.supsi.backend.observers.utils;

public interface ISubject {
  void attach(Observer o);
  void detach(Observer o);
  void notifyObservers();
}
