package com.supsi.backend.state.plant;

import com.supsi.backend.model.plants.Plant;

public class PlantChargingState implements PlantState {
    @Override
    public PlantStateType getState() {
        return PlantStateType.CHARGING;
    }

    @Override
    public void setReady(Plant plant) {
        plant.setState(new PlantReadyState());
    }

    @Override
    public void setCharging(Plant plant) {
        throw new UnsupportedOperationException();
    }
}
