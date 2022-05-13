package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;

public abstract class Plant {

    private int health;
    private int attack;
    private int sunGeneration;
    private boolean isAlive = true;
    private int price;

    public Plant(int health, int attack, int sunGeneration, Integer price) {
        this.health = health;
        this.attack = attack;
        this.sunGeneration = sunGeneration;
        this.price = price;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int health) {
        this.health += Math.abs(health);
    }

    public void takeDamage(int damage) {
        int effectiveDamage = Math.abs(damage);
        health -= effectiveDamage;
        if (health - effectiveDamage <= 0)
            isAlive = false;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public boolean isAlive() {
        return isAlive;
    }

}
