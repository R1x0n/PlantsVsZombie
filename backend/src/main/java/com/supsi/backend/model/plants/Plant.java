package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;

public abstract class Plant {

    int health;
    int attack;
    int sunGeneration;
    private Integer price;

    public Plant(int health, int attack, int sunGeneration, Integer price) {
        this.health = health;
        this.attack = attack;
        this.sunGeneration = sunGeneration;
        this.price = price;
    }

    public int getHealth() {
        return health;
    }

    public int takeDamage(int damage) {
        return health -= damage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
