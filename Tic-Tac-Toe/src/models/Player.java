package models;

import strategies.PlayerStrategy;

public class Player {
    private Symbol symbol;
    private PlayerStrategy playerStrategy;

    public Player(Symbol symbol, PlayerStrategy playerStrategy) {
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Position makeMove(Board board) {
        return playerStrategy.makeMove(board);
    }
}
