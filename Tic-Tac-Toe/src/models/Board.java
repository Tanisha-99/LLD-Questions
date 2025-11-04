package models;

import states.GameContext;

public class Board {
    private final int rows;
    private final int columns;

    private Symbol[][] grid;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        grid = new Symbol[rows][columns];

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                grid[row][column] = Symbol.EMPTY;
            }
        }
    }

    public boolean isValidMove(Position position) {
        int row = position.getRow();
        int column = position.getColumn();

        return row >= 0 && row < rows && column >= 0 && column < columns && grid[row][column] == Symbol.EMPTY;
    }

    public void makeMove(Position position, Symbol symbol) {
        int row = position.getRow();
        int column = position.getColumn();

        grid[row][column] = symbol;
    }

    public void checkGameState(GameContext gameContext) {
        for(int row = 0; row < rows; row++) {
            if(grid[row][0] != Symbol.EMPTY && isWinningLine(grid[row]))
            {
                gameContext.next(true);
                return;
            }
        }

        for(int column = 0; column < columns; column++) {
            Symbol[] columnLine = new Symbol[rows];
            for(int row = 0; row < rows; row++) {
                columnLine[row] = grid[row][column];
            }

            if(columnLine[0] != Symbol.EMPTY && isWinningLine(columnLine)) {
                gameContext.next(true);
                return;
            }
        }

        Symbol[] diagonalLine1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonalLine2 = new Symbol[Math.min(rows, columns)];

        for(int i = 0; i < Math.min(rows, columns); i++) {
            diagonalLine1[i] = grid[i][i];
            diagonalLine2[i] = grid[i][columns - 1 - i];
        }

        if(diagonalLine1[0] != Symbol.EMPTY && isWinningLine(diagonalLine1)) {
            gameContext.next(true);
            return;
        }

        if(diagonalLine2[0] != Symbol.EMPTY && isWinningLine(diagonalLine2)) {
            gameContext.next(true);
            return;
        }

        //Additional logic to handle a draw or continue in progress can be added/
    }

    private boolean isWinningLine(Symbol[] line) {
        Symbol first = line[0];

        for(Symbol symbol : line) {
            if(symbol != first) {
                return false;
            }
        }

        return true;
    }

    public void printBoard() {
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                System.out.print(grid[row][column] + " ");
            }

            System.out.println();
        }
    }
}
