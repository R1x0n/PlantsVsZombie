package com.supsi.backend.model.plants;

import com.supsi.backend.model.others.Configs;

public class DefensePlant extends Plant {

    public DefensePlant() {
        super(200, 0, 0, Configs.getInstance().getDefensePlantCost(), 15000);
    }

}