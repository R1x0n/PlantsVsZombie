package com.supsi.pvz.observers;

import com.supsi.pvz.controllers.PointsFieldController;
import com.supsi.pvz.observers.utils.Observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

  @Test
  void getInstance() {
    Points p = Points.getInstance();
    Points p2 = Points.getInstance();

    assertEquals(p, p2);
  }

  @Test
  void getState() {
    Points p = new Points();

    assertEquals(0, p.getState());
  }

  @Test
  void setState() {
    Points p = new Points();
    p.setState(10);
    
    assertEquals(10, p.getState());
  }

  @Test
  void add() {
    Points p = new Points();
    p.add(10);
    assertEquals(10, p.getState());

    p.add(-10);
    assertEquals(0, p.getState());
  }

  @Test
  void remove() {
    Points p = new Points();
    p.add(10);

    p.remove(5);
    assertEquals(5, p.getState());

    p.remove(10);
    assertEquals(0, p.getState());
  }

  @Test
  void addSameObserver() {
    Points p = new Points();
    Observer o = new PointsFieldController();
    p.attach(o);
    p.attach(o);

    assertEquals(1, p.getObservers().size());
  }

  @Test
  void removeObserverThatIsNotThere() {
    Points p = new Points();
    Observer o = new PointsFieldController();
    p.detach(o);

    assertEquals(0, p.getObservers().size());
  }

  @Test
  void attach() {
    Points p = new Points();
    Observer o = new PointsFieldController();
    p.attach(o);

    assertTrue(p.getObservers().contains(o));
  }

  @Test
  void detach() {
    Points p = new Points();
    Observer o = new PointsFieldController();
    p.attach(o);
    p.detach(o);

    assertFalse(p.getObservers().contains(o));
  }
}
