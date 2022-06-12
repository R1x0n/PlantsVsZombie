package com.supsi.backend.state.game;

import com.supsi.backend.model.others.Configs;
import com.supsi.backend.observers.KillCounter;
import com.supsi.backend.observers.Points;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void getInstance() {
        Game game = Game.getInstance();
        assertNotNull(game);
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
    }

    @Test
    void startGame() {
        Game game = new Game();
        game.setGameOver();
        KillCounter.getInstance().add();
        Points.getInstance().add(10);

        game.startGame();
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
        assertEquals(KillCounter.getInstance().getState(), 0);
        assertEquals(Points.getInstance().getState(), Configs.getInstance().getInitialPoints());
    }

    @Test
    void setStatus() {
        Game game = new Game();
        game.setStatus(new GameoverState());
        assertEquals(GameStatusTypes.GAMEOVER, game.getStatus());
    }

    @Test
    void setGameOver() {
        Game game = new Game();
        game.setGameOver();
        assertEquals(GameStatusTypes.GAMEOVER, game.getStatus());
    }

    @Test
    void setGameOverException() {
        Game game = new Game();
        game.setGameOver();
        game.setGameOver();
        assertEquals("Game status already set to gameover" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void setRunning() {
        Game game = new Game();
        game.setGameOver();
        game.setRunning();
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
    }

    @Test
    void setRunningException() {
        Game game = new Game();
        game.setRunning();
        assertEquals("Game status already set to running" + System.lineSeparator(), outContent.toString());
    }

    @Test
    void getStatus() {
        Game game = new Game();
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
    }

    @Test
    void catchException() {
        Game game = new Game();
        GameoverState state = new GameoverState();
        assertThrows(UnsupportedOperationException.class, () -> state.setGameOver(game));
        RunningState state2 = new RunningState();
        assertThrows(UnsupportedOperationException.class, () -> state2.setRunning(game));
    }
}
