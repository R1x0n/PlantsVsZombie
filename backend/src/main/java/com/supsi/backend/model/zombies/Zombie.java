package com.supsi.backend.model.zombies;

public abstract class Zombie {

    private int health;
    private final int damage;
    private final double speed;

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

    public int takeDamage(int damage) {
        health = health >= damage ? health - damage : 0;
        return health;
    }
}
