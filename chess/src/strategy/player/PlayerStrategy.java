package strategy.player;

public interface PlayerStrategy {
    Move makeMove(Board board, boolean isWhiteTurn);
}
