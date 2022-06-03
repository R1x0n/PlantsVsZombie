package com.supsi.frontend;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.supsi.backend.state.game.Game;
import com.supsi.backend.state.game.GameStatusTypes;
import com.supsi.frontend.components.lawnmower.LawnmowerComponent;
import com.supsi.frontend.components.plant.PlantComponent;
import com.supsi.frontend.components.projectile.BasicProjectileComponent;
import com.supsi.frontend.components.zombie.ZombieComponent;
import com.supsi.frontend.factories.gameGrid.GridFactory;
import com.supsi.frontend.factories.hud.pauseButton.PauseButtonFactory;
import com.supsi.frontend.factories.hud.selectorGrid.SelectorGridFactory;
import com.supsi.frontend.factories.lawnmower.LawnmowerFactory;
import com.supsi.frontend.factories.lawnmower.LawnmowerTypes;
import com.supsi.frontend.factories.plant.PlantFactory;
import com.supsi.frontend.factories.plant.PlantTypes;
import com.supsi.frontend.factories.projectile.ProjectileFactory;
import com.supsi.frontend.factories.projectile.ProjectileTypes;
import com.supsi.frontend.factories.sun.SunFactory;
import com.supsi.frontend.factories.zombie.ZombieFactory;
import com.supsi.frontend.factories.zombie.ZombieTypes;
import com.supsi.frontend.observers.EnemySpawner;
import com.supsi.frontend.observers.KillCounterObserver;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.util.Objects;
import javafx.scene.image.Image;
import javafx.util.Duration;

import javafx.scene.image.Image;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGL.getGameScene;
import static com.almasb.fxgl.dsl.FXGL.getGameTimer;
import static com.almasb.fxgl.dsl.FXGL.getGameWorld;
import static com.almasb.fxgl.dsl.FXGL.onCollisionBegin;
import static com.almasb.fxgl.dsl.FXGL.run;
import static com.almasb.fxgl.dsl.FXGL.spawn;
import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

public class MainApplication extends GameApplication {

    private static final String windowTitle = "PvZ";
    private final KillCounterObserver killCounterController = new KillCounterObserver();
    private final Game mainGame = Game.getInstance();
    private final EnemySpawner enemySpawner = new EnemySpawner();

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

    private void initFactories() {
        getGameWorld().addEntityFactory(new SunFactory());
        getGameWorld().addEntityFactory(new ZombieFactory());
        getGameWorld().addEntityFactory(new GridFactory());
        getGameWorld().addEntityFactory(new SelectorGridFactory());
        getGameWorld().addEntityFactory(new PlantFactory());
        getGameWorld().addEntityFactory(new ProjectileFactory());
        getGameWorld().addEntityFactory(new PauseButtonFactory());
        getGameWorld().addEntityFactory(new LawnmowerFactory());
    }

    private void initLawnmower() {
        for (int i = 0; i < 5; i++) {
            spawn("lawnmower", 156, 216 + i * 100);
        }
    }

    @Override
    protected void initGame() {
        mainGame.startGame();

        initFactories();
        initLawnmower();
        getGameScene().setBackgroundRepeat("Background.png");

        spawn("gameGrid", 265, 200);
        spawn("selectorGrid", 20, 20);
        spawn("pauseButton", getAppWidth() - 80, 10);

        run(() -> spawn("sunFromSky", FXGL.random(265, 985), -30), Duration.seconds(15));

        getGameTimer().runOnceAfter(() -> enemySpawner.start(Duration.seconds(5)) , Duration.seconds(15));
    }

    @Override
    protected void onUpdate(double tpf) {
        checkGameStatus(Game.getInstance());
    }

    @Override
    protected void initPhysics() {
        onCollisionBegin(PlantTypes.PLANT, ZombieTypes.ZOMBIE, (plant, zombie) -> {
            var plantComponent = (PlantComponent) plant.getComponents().stream().filter(PlantComponent.class::isInstance).findFirst().orElse(null);
            var zombieComponent = (ZombieComponent) zombie.getComponents().stream().filter(ZombieComponent.class::isInstance).findFirst().orElse(null);
            Objects.requireNonNull(zombieComponent).eating(Objects.requireNonNull(plantComponent).getPlant());
        });

        onCollisionBegin(ProjectileTypes.PROJECTILE_NORMAL, ZombieTypes.ZOMBIE, (projectile, zombie) -> {
            var projectileComponent = (BasicProjectileComponent) projectile.getComponents().stream().filter(BasicProjectileComponent.class::isInstance).findFirst().orElse(null);
            var zombieComponent = (ZombieComponent) zombie.getComponents().stream().filter(ZombieComponent.class::isInstance).findFirst().orElse(null);
            Objects.requireNonNull(projectileComponent).hitZombie(Objects.requireNonNull(zombieComponent).getZombie());
        });

        onCollisionBegin(LawnmowerTypes.LAWNMOWER, ZombieTypes.ZOMBIE, (lawnmower, zombie) -> {
            var lawnmowerComponent = (LawnmowerComponent) lawnmower.getComponents().stream()
                    .filter(LawnmowerComponent.class::isInstance).findFirst().orElse(null);
            zombie.removeFromWorld();
            Objects.requireNonNull(lawnmowerComponent).cutZombie(Objects.requireNonNull(lawnmowerComponent), zombie);
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
