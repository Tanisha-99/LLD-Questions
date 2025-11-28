import entities.PieceType;
import strategy.movement.MovementStrategy;

public abstract class Piece {
    protected boolean isWhite;
    protected boolean isKilled;
    protected MovementStrategy movementStrategy;

    public Piece(boolean isWhite, MovementStrategy movementStrategy) {
        this.isWhite = isWhite;
        this.isKilled = false;
        this.movementStrategy = movementStrategy;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public boolean isWhite() {
        return isWhite;
    }

    protected abstract PieceType getType();

    protected boolean canMove(Move move) {
        return movementStrategy.canMove(move);
    }
}
