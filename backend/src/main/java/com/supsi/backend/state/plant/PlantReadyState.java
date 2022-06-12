package com.supsi.backend.state.plant;

import com.supsi.backend.model.plants.Plant;

public class PlantReadyState implements PlantState {
    @Override
    public PlantStateType getState() {
        return PlantStateType.READY;
    }

    @Override
    public void setReady(Plant plant) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCharging(Plant plant) {
        plant.setState(new PlantChargingState());
    }
}
