import entities.PieceType;
import strategy.movement.MovementStrategy;

public class Bishop extends Piece{
    public Bishop(boolean isWhite, MovementStrategy movementStrategy) {
        super(isWhite, movementStrategy);
    }

    @Override
    public PieceType getType() {
        return PieceType.BISHOP;
    }
}
