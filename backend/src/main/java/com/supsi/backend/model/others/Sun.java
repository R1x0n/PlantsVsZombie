package com.supsi.backend.model.others;

import com.supsi.backend.observers.Points;

public class Sun {
    private static final Points currentPoints = Points.getInstance();
    private final double despawnTimeInMilliseconds = Configs.getInstance().getSunDespawnTimeInMilliseconds();

    public void addPoints(int points) {
        currentPoints.add(points);
    }

    public double getDespawnTimeInMilliseconds() {
        return despawnTimeInMilliseconds;
    }
}
