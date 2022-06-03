package com.supsi.backend.state.game;

public class GameoverState implements GameStatus {
    @Override
    public GameStatusTypes getStatus() {
        return GameStatusTypes.GAMEOVER;
    }

    @Override
    public void setGameOver(Game game) {
            throw new UnsupportedOperationException();
    }

    @Override
    public void setRunning(Game game) {
        game.setStatus(new RunningState());
    }

}
