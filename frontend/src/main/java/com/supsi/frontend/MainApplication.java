package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.supsi.frontend.factories.SunFactory;
import com.supsi.frontend.factories.ZombieFactory;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

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
        getGameWorld().addEntityFactory(new ZombieFactory());

        run(() -> {
            double x = getAppWidth() + 30; // + 30 = shape init outside of screen

            spawn("zombie_tank", x, FXGLMath.random(20, getAppHeight() - 20));
            spawn("zombie_runner", x, FXGLMath.random(20, getAppHeight() - 20));
            spawn("zombie_normal", x, FXGLMath.random(20, getAppHeight() - 20));
            spawn("sun", FXGLMath.random(0, getAppWidth() - 40), -30);
        }, Duration.seconds(2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
