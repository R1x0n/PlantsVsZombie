package com.supsi.backend.model.plants;

public abstract class AbstractPlant {

    int health;
    int attack;
    int sunGeneration;

    public AbstractPlant(int health, int attack, int sunGeneration) {
        this.health = health;
        this.attack = attack;
        this.sunGeneration = sunGeneration;
    }

    public int getHealth() {
        return health;
    }

    public int takeDamage(int damage) {
        return health -= damage;
    }

}
