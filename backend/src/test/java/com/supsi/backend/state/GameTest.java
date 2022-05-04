package com.supsi.backend.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void getInstance() {
        Game game = new Game();
        assertNotNull(game);
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
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
    void setRunning() {
        Game game = new Game();
        game.setGameOver();
        game.setRunning();
        assertEquals(GameStatusTypes.RUNNING, game.getStatus());
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