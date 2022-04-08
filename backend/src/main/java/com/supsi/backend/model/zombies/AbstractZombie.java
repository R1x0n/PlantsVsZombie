package com.supsi.backend.model.zombies;

public abstract class AbstractZombie {

    private int health;
    private final double eatingRate;
    private final double speed;

    public AbstractZombie(int health, double eatingRate, double speed) {
        this.health = health;
        this.eatingRate = eatingRate;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public double getEatingRate() {
        return eatingRate;
    }

    public int takeDamage(int damage) {
        health = health >= damage ? health - damage : 0;
        return health;
    }

    public void attackPlant() {
        // TODO: chiamerà il metodo takeDamage() delle piante (magari tramite un Handler?)
    }
}
