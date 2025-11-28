import entities.PieceType;
import strategy.movement.MovementStrategy;

public class Pawn extends Piece{

    public Pawn(boolean isWhite, MovementStrategy movementStrategy) {
        super(isWhite, movementStrategy);
    }

    @Override
    public PieceType getType() {
        return PieceType.PAWN;
    }
}
