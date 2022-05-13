package com.supsi.backend.model.others;

public class Projectile {
    private final int damage;

    public Projectile() {
        Configs configs = Configs.getInstance();
        this.damage = configs.getProjectileDamage();
    }

    public int getDamage() {
        return this.damage;
    }
}
