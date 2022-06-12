package com.supsi.backend.model.others;

import com.supsi.backend.observers.Points;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SunTest {
    @BeforeEach
    void setUp() {
        Points.getInstance().setState(Configs.getInstance().getInitialPoints());
    }

    @Test
    void addPoints() {
        Sun sun = new Sun();
        Points p = Points.getInstance();
        int initialPoints = Configs.getInstance().getInitialPoints();

        sun.addPoints(0);
        assertEquals(p.getState(), initialPoints);

        sun.addPoints(50);
        assertEquals(p.getState(), initialPoints + 50);

        sun.addPoints(100);
        assertEquals(p.getState(), initialPoints + 150);
    }

    @Test
    void getDespawnTimeInMilliseconds() {
        Sun sun = new Sun();
        assertEquals(sun.getDespawnTimeInMilliseconds(), Configs.getInstance().getSunDespawnTimeInMilliseconds());
    }
}
