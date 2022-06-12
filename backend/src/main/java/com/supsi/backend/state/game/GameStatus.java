package com.supsi.backend.state.game;

public interface GameStatus {
    GameStatusTypes getStatus();

    void setGameOver(Game game);

    void setRunning(Game game);

}
