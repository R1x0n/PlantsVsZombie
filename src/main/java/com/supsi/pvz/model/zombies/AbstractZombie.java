package com.supsi.pvz.model.zombies;

public abstract class AbstractZombie {

    int health;
    double eatingRate;
    double speed;

    public AbstractZombie(int health, double eatingRate, double speed) {
        this.health = health;
        this.eatingRate = eatingRate;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public int takeDamage(int damage) {
        return health -= damage;
    }

    public void attackPlant() {
        // chiamerà il metodo takeDamage() delle piante (magari tramite un Handler?)
    }

}
