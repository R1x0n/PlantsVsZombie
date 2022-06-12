package com.supsi.backend.model.zombies;

import com.supsi.backend.observers.KillCounter;

public abstract class Zombie {

    private int health;
    private final int damage;
    private final double speed;
    private boolean isAlive = true;

    public Zombie(int health, int damage, double speed) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health = health >= damage ? health - damage : 0;

        if (health <= 0) {
            isAlive = false;
            KillCounter.getInstance().add();
        }
    }

    public void addHealth(int damage) {
        health += Math.abs(damage);
    }

    public boolean isAlive() {
        return isAlive;
    }
}
