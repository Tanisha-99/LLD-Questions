package states;

public class GameContext {
    private GameState currentGameState;

    public GameContext() {
        currentGameState = new XTurnState();
    }

    public void next(boolean hasWon) {
        currentGameState.next(this, hasWon);
    }

    public GameState getCurrentGameState() {
        return currentGameState;
    }

    public boolean isGameOver() {
        return currentGameState.isGameOver();
    }

    public void setNext(GameState nextGameState) {
        currentGameState = nextGameState;
    }

    public boolean hasWon() {
        return false;
    }
}
