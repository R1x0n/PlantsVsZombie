package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.supsi.frontend.factories.GridFactory;
import com.supsi.frontend.factories.SunFactory;
import com.supsi.frontend.factories.ZombieFactory;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static com.almasb.fxgl.dsl.FXGL.*;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppHeight;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;

public class MainApplication extends GameApplication {

    private static final String windowTitle = "PvZ";

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setMainMenuEnabled(true);
        settings.setTitle(windowTitle);
        settings.setWidth(1027);
        settings.setHeight(770);
    }

    @Override
    protected void initGame() {
        Image background = null;

        try {
            background = new Image(new FileInputStream("frontend/src/main/resources/background.png"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        getGameScene().setBackgroundRepeat(background);

        getGameWorld().addEntityFactory(new SunFactory());
        getGameWorld().addEntityFactory(new ZombieFactory());
        getGameWorld().addEntityFactory(new GridFactory());

        spawn("gameGrid", 265, 200);

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
