package com.supsi.backend.observers;

import com.supsi.backend.model.others.Configs;
import com.supsi.backend.observers.utils.Observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverImpl implements Observer {
  @Override
  public void update() {
    // Ignored
  }
}

class PointsTest {

  private Configs configs = Configs.getInstance();

  @Test
  void getInstance() {
    Points p = Points.getInstance();
    Points p2 = Points.getInstance();

    assertEquals(p, p2);
  }

  @Test
  void getState() {
    Points p = new Points();

    assertEquals(configs.getInitialPoints(), p.getState());
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
    assertEquals(configs.getInitialPoints() + 10, p.getState());

    p.add(-10);
    assertEquals(configs.getInitialPoints(), p.getState());
  }

  @Test
  void remove() {
    Points p = new Points();
    p.remove(5);
    assertEquals(configs.getInitialPoints() - 5, p.getState());

    p.remove(10000);
    assertEquals(0, p.getState());
  }


  @Test
  void addSameObserver() {
    Points p = new Points();
    Observer o = new ObserverImpl();
    p.attach(o);
    p.attach(o);

    assertEquals(1, p.getObservers().size());
  }

  @Test
  void removeObserverThatIsNotThere() {
    Points p = new Points();
    Observer o = new ObserverImpl();
    p.detach(o);

    assertEquals(0, p.getObservers().size());
  }

  @Test
  void attach() {
    Points p = new Points();
    Observer o = new ObserverImpl();
    p.attach(o);

    assertTrue(p.getObservers().contains(o));
  }

  @Test
  void detach() {
    Points p = new Points();
    Observer o = new ObserverImpl();
    p.attach(o);
    p.detach(o);

    assertFalse(p.getObservers().contains(o));
  }

  @Test
  void reset() {
    Points p = new Points();
    p.add(50);
    p.reset();

    assertEquals(Configs.getInstance().getInitialPoints(), p.getState());
  }
}
