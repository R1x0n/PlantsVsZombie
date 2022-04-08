package com.supsi.backend.model.others;

import com.supsi.backend.observers.Points;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SunTest {

    @Test
    void addPoints() {
        Sun sun = new Sun();
        Points p = Points.getInstance();
        sun.addPoints(0);
        assertEquals(p.getState(), 0);

        sun.addPoints(50);
        assertEquals(p.getState(), 50);

        sun.addPoints(100);
        assertEquals(p.getState(), 150);
    }
}