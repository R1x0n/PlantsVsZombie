package com.supsi.backend.model.plants;

import com.supsi.backend.state.plant.PlantState;
import com.supsi.backend.state.plant.PlantReadyState;
import com.supsi.backend.state.plant.PlantStateType;

public abstract class Plant {

    private int health;
    private int attack;
    private int sunGeneration;
    private boolean isAlive = true;
    private int price;
    private final int rechargeTime;
    private PlantState state;

    public Plant(int health, int attack, int sunGeneration, Integer price, int rechargeTime) {
        this.health = health;
        this.attack = attack;
        this.sunGeneration = sunGeneration;
        this.price = price;
        this.rechargeTime = rechargeTime;
        this.state = new PlantReadyState();
    }

    public void setState(PlantState state) {
        this.state = state;
    }

    public void setCharging() {
        try {
            state.setCharging(this);
        } catch (UnsupportedOperationException e) {
            System.out.println("Plant already charging");
        }
    }

    public void setReady() {
        try {
            state.setReady(this);
        } catch (UnsupportedOperationException e) {
            System.out.println("Plant already ready");
        }
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

    public int getRechargeTime() {
        return rechargeTime;
    }

    public PlantStateType getState() {
        return state.getState();
    }
}
