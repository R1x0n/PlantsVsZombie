package com.supsi.backend.state.plant;

import com.supsi.backend.model.plants.Plant;

public interface PlantState {
    PlantStateType getState();

    void setReady(Plant plant);

    void setCharging(Plant plant);
}
