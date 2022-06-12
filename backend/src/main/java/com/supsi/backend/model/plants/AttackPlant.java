package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;

public class AttackPlant extends Plant {

    public AttackPlant() {
        super(100, 1, 0, Configs.getInstance().getAttackPlantCost(), 8000);
    }

}
