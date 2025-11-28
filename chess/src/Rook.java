import entities.PieceType;
import strategy.movement.MovementStrategy;

public class Rook extends Piece{

    public Rook(boolean isWhite, MovementStrategy movementStrategy) {
        super(isWhite, movementStrategy);
    }

    @Override
    public PieceType getType() {
        return PieceType.ROOK;
    }
}
