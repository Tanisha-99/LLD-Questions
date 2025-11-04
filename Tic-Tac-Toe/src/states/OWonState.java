package states;

public class OWonState implements GameState{

    @Override
    public void next(GameContext gameContext, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }
}
