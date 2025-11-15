public class Board {
    private int rows;
    private int columns;
    private Cell[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initialiseBoard();
    }

    public Cell[][] getGrid() {
        return grid;
    }

    private void initialiseBoard() {
        grid = new Cell[rows][columns];

        //place white pieces
        setPieceRow(0, true);
        setPawnRow(1, true);

        //set black pieces
        setPieceRow(rows - 1, false);
        setPawnRow(rows - 2, false);

        for(int row = 2; row < rows - 2; row++) {
            for(int col = 0; col < columns; col++) {
                grid[row][col] = new Cell(row, col, null);
            }
        }
    }

    private void setPieceRow(int row, boolean isWhite) {
        grid[row][0] = new Cell(row, 0, PieceFactory.createPiece("rook", isWhite));
        grid[row][1] = new Cell(row, 1, PieceFactory.createPiece("knight", isWhite));
        grid[row][2] = new Cell(row, 2, PieceFactory.createPiece("bishop", isWhite));
        grid[row][3] = new Cell(row, 3, PieceFactory.createPiece("queen", isWhite));
        grid[row][4] = new Cell(row, 4, PieceFactory.createPiece("king", isWhite));
        grid[row][5] = new Cell(row, 5, PieceFactory.createPiece("bishop", isWhite));
        grid[row][6] = new Cell(row, 6, PieceFactory.createPiece("knight", isWhite));
        grid[row][7] = new Cell(row, 7, PieceFactory.createPiece("rook", isWhite));
    }

    private void setPawnRow(int row, boolean isWhite) {
        for (int col = 0; col < 8; col++) {
            grid[row][col] = new Cell(row, col, PieceFactory.createPiece("pawn", isWhite));
        }
    }

    public void makeMove(Move move, Player currentPlayer) {

    }
}
