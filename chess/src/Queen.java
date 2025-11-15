public class Queen extends Piece{

    public Queen(boolean isWhite, MovementStrategy movementStrategy) {
        super(isWhite, movementStrategy);
    }

    @Override
    public PieceType getType() {
        return PieceType.QUEEN;
    }
}
