public class Move {
    private Cell start;
    private Cell end;

    public Move(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }

    public Cell getStart() {
        return start;
    }

    public Cell getEnd() {
        return end;
    }

    // just specify verbally that this function should not be part of move class but a diff moveValidator class
    public static boolean isMoveValid(Move move, Board board, boolean isWhiteTurn) {
        Cell sourceCell = move.getStart();
        Cell targetCell = move.getEnd();

        //boundary check
        if(sourceCell.getRow() < 0 || targetCell.getRow() < 0 || sourceCell.getCol() < 0 || targetCell.getCol() < 0 || sourceCell.getRow() >= 8 || sourceCell.getCol() >= 8 || targetCell.getRow() >= 8 || targetCell.getCol() >= 8) {
            return false;
        }

        //source cell contains the same player piece
        sourceCell = board.getGrid()[sourceCell.getRow()][sourceCell.getCol()];
        Piece piece = sourceCell.getPiece();
        if(piece == null || piece.isKilled || piece.isWhite != isWhiteTurn) {
            return false;
        }

        //destination cell contains the piece of same player
        targetCell = board.getGrid()[targetCell.getRow()][targetCell.getCol()];
        Piece targetPiece = targetCell.getPiece();

        if(piece != null && !piece.isKilled && targetPiece.isWhite == isWhiteTurn) {
            return false;
        }

        //valid according to the piece movement rules
        return piece.canMove(move);
    }
}
