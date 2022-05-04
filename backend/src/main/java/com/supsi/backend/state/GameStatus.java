package com.supsi.backend.state;

public interface GameStatus {
    GameStatusTypes getStatus();

    void setGameOver(Game game);

    void setRunning(Game game);

}
