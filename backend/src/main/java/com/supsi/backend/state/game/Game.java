package com.supsi.backend.state.game;

import com.supsi.backend.observers.KillCounter;
import com.supsi.backend.observers.Points;

import java.util.concurrent.atomic.AtomicReference;

public class Game {
    private static final AtomicReference<Game> instance = new AtomicReference<>();
    private GameStatus state;

    public static Game getInstance() {
        instance.compareAndSet(null, new Game());
        return instance.get();
    }

    public void startGame() {
        state = initGameStatus();
        KillCounter.getInstance().reset();
        Points.getInstance().reset();
    }

    protected void setStatus(GameStatus newStatus) {
        state = newStatus;
    }

    public void setGameOver() {
        try {
            state.setGameOver(this);
        }
        catch(UnsupportedOperationException ex) {
            System.out.println("Game status already set to gameover");
        }
    }

    public void setRunning() {
        try {
            state.setRunning(this);
        }
        catch(UnsupportedOperationException ex) {
            System.out.println("Game status already set to running");
        }
    }

    public GameStatusTypes getStatus() {
        return state.getStatus();
    }

    protected Game() {
        state = initGameStatus();
    }

    private static GameStatus initGameStatus() {
        return new RunningState();
    }

}
