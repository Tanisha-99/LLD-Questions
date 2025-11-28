import entities.PieceType;
import strategy.movement.MovementStrategy;

public class Knight extends Piece{

    public Knight(boolean isWhite, MovementStrategy movementStrategy) {
        super(isWhite, movementStrategy);
    }

    @Override
    public PieceType getType() {
        return PieceType.KNIGHT;
    }
}
