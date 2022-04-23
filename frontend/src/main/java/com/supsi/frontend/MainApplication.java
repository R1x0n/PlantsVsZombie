package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.core.math.FXGLMath;
import com.supsi.backend.Utils;
import com.supsi.frontend.factories.GridFactory;
import com.supsi.frontend.factories.SunFactory;
import com.supsi.frontend.factories.ZombieFactory;
import javafx.scene.image.Image;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

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

    private void initBackground() {
        Image background = null;

        try {
          background = new Image(new FileInputStream("frontend/src/main/resources/background.png"));
        } catch(FileNotFoundException e) {
          e.printStackTrace();
        }

        getGameScene().setBackgroundRepeat(background);
    }

    private void initFactories() {
      getGameWorld().addEntityFactory(new SunFactory());
      getGameWorld().addEntityFactory(new ZombieFactory());
      getGameWorld().addEntityFactory(new GridFactory());
    }

    @Override
    protected void initGame() {
        initBackground();
        initFactories();

        spawn("gameGrid", 265, 200);

        run(() -> spawn("sun", Utils.randomCoordinate(265, 985), -30), Duration.seconds(15));

        // y positions of zombies to spawn + /2 zombie height
        int[] zombieSpawnPositions = {280, 380, 480, 580, 680};
        Random random = new Random();

        run(() -> {
            double x = getAppWidth() + 30; // + 30 = shape init outside of screen
            var selectedZombie = ZombieFactory.zombies[random.nextInt(ZombieFactory.zombies.length)];
            var selectedPosition = zombieSpawnPositions[random.nextInt(zombieSpawnPositions.length)];
            spawn(selectedZombie, x, selectedPosition);
        }, Duration.seconds(2));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
