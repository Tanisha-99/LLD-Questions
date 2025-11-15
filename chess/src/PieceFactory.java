public abstract class PieceFactory {

    public static Piece createPiece(String pieceType, boolean isWhite) {
        switch(pieceType.toLowerCase()) {
            case "king":
                return new King(isWhite, new KingMovementStrategy());

            case "queen":
                return new Queen(isWhite, new QueenMovementStrategy());

            case "bishop":
                return new Bishop(isWhite, new BishopMovementStrategy());

            case "rook":
                return new Rook(isWhite, new RookMovementStrategy());

            case "knight":
                return new Knight(isWhite, new KnightMovementStrategy());

            case "pawn":
                return new Pawn(isWhite, new PawnMovementStrategy());

            default:
                throw new IllegalArgumentException("Unknown piece type: " + pieceType);
        }
    }
}
