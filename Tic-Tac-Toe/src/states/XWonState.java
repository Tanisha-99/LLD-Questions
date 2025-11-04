package states;

public class XWonState implements GameState{

    @Override
    public void next(GameContext gameContext, boolean hasWon) {

    }

    @Override
    public boolean isGameOver() {
        return true;
    }

}
