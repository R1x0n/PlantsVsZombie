package com.supsi.backend.model.others;

import com.supsi.backend.observers.Points;

public class Sun {
    private static final Points currentPoints = Points.getInstance();

    public Sun() {
    }

    public void addPoints(int points) {
        currentPoints.add(points);
    }
}