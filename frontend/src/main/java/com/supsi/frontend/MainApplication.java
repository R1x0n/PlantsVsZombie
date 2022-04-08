package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.supsi.frontend.factories.SunFactory;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;

public class MainApplication extends GameApplication {

    private static final String windowTitle = "PvZ";

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setMainMenuEnabled(true);

        settings.setTitle(windowTitle);
        settings.setWidth(1000);
        settings.setHeight(800);
    }

    @Override
    protected void initGame() {
        getGameScene().setBackgroundColor(Color.BLACK);

        getGameWorld().addEntityFactory(new SunFactory());

        run(() -> {
            spawn("sun", FXGLMath.random(0, getAppWidth() - 40), -30);
        }, Duration.seconds(2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}