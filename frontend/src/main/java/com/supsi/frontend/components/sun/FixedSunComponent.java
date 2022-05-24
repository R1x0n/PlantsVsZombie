package com.supsi.frontend.components.sun;

public class FixedSunComponent extends SunComponent {

    public FixedSunComponent() {
        super();
        movementComponent.pause();
    }

    @Override
    public void onAdded() {
        super.onAdded();
        initDespawn();
    }
}
