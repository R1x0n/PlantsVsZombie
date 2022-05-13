package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.supsi.backend.Utils;
import com.supsi.backend.state.Game;
import com.supsi.backend.state.GameStatusTypes;
import com.supsi.frontend.factories.gameGrid.GridFactory;
import com.supsi.frontend.factories.selectorGrid.SelectorGridFactory;
import com.supsi.frontend.factories.plant.PlantFactory;
import com.supsi.frontend.factories.projectile.ProjectileTypes;
import com.supsi.frontend.factories.sun.SunFactory;
import com.supsi.frontend.factories.zombie.ZombieFactory;
import com.supsi.frontend.factories.projectile.ProjectileFactory;
import com.supsi.frontend.factories.zombie.ZombieTypes;
import com.supsi.frontend.observers.KillCounterObserver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import static com.almasb.fxgl.dsl.FXGL.*;
import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getAppWidth;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getDialogService;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameController;

public class MainApplication extends GameApplication {

    private static final String windowTitle = "PvZ";
    private final KillCounterObserver killCounterController = new KillCounterObserver();
    private final Game mainGame = Game.getInstance();

    private void checkGameStatus(Game game) {
        if (game.getStatus() == GameStatusTypes.GAMEOVER) {
            getDialogService().showMessageBox("GAME OVER! You killed " + killCounterController.counter + " zombies!\n\nPress OK to start a new game!", getGameController()::startNewGame);
        }
    }

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        getGameScene().setBackgroundRepeat(background);
    }

    private void initFactories() {
      getGameWorld().addEntityFactory(new SunFactory());
      getGameWorld().addEntityFactory(new ZombieFactory());
      getGameWorld().addEntityFactory(new GridFactory());
      getGameWorld().addEntityFactory(new SelectorGridFactory());
      getGameWorld().addEntityFactory(new PlantFactory());
        getGameWorld().addEntityFactory(new ProjectileFactory());
    }

    @Override
    protected void initGame() {
        mainGame.startGame();
        initBackground();
        initFactories();

        spawn("gameGrid", 265, 200);
        spawn("selectorGrid", 20 ,20);

        run(() -> spawn("sun", Utils.randomCoordinate(265, 985), -30), Duration.seconds(15));

        // y positions of zombies to spawn - 60 for the collision box
        int[] zombieSpawnPositions = {220, 320, 420, 520, 620};
        Random random = new Random();

        run(() -> {
            double x = getAppWidth() + 30; // + 30 = shape init outside of screen
            var selectedZombie = ZombieFactory.zombies[random.nextInt(ZombieFactory.zombies.length)];
            var selectedPosition = zombieSpawnPositions[random.nextInt(zombieSpawnPositions.length)];
            spawn(selectedZombie, x, selectedPosition);
        }, Duration.seconds(2));
    }

    @Override
    protected void onUpdate(double tpf) {
        checkGameStatus(Game.getInstance());
    }

    @Override
    protected void initPhysics() {
        onCollisionBegin(ProjectileTypes.PROJECTILE_NORMAL, ZombieTypes.ZOMBIE, (projectile, zombie) -> projectile.removeFromWorld());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
