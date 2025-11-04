package states;

public interface GameState {
    void next(GameContext gameContext, boolean hasWon);

    boolean isGameOver(); //can have another state instead of this function - isOverState
}
