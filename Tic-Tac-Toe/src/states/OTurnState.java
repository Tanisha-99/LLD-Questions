package states;

public class OTurnState implements GameState{

    @Override
    public void next(GameContext gameContext, boolean hasWon) {
        if(hasWon) {
            gameContext.setNext(new OWonState());
        }
        else {
            gameContext.setNext(new XTurnState());
        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
