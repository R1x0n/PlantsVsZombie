package com.supsi.backend.state;

public class RunningState implements GameStatus {
    @Override
    public GameStatusTypes getStatus() {
        return GameStatusTypes.RUNNING;
    }

    @Override
    public void setGameOver(Game game) {
        game.setStatus(new GameoverState());
    }

    @Override
    public void setRunning(Game game) {
            throw new UnsupportedOperationException();
    }
}
