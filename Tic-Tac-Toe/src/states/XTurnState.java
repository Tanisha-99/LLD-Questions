package states;

public class XTurnState implements GameState{

    @Override
    public void next(GameContext gameContext, boolean hasWon) {

        if(hasWon) {
            gameContext.setNext(new XWonState());
        }
        else {
            gameContext.setNext(new OTurnState());
        }

    }

    @Override
    public boolean isGameOver() {
        return false;
    }
}
