package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class MainApplication extends GameApplication {

    private static final String windowTitle = "PvZ";

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setMainMenuEnabled(true);

        settings.setTitle(windowTitle);
        settings.setWidth(1000);
        settings.setHeight(800);
    }

    public static void main(String[] args) {
        launch(args);
    }
}