package strategy.player;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    Scanner scanner = new Scanner(System.in);

    @Override
    public Move makeMove(Board board, boolean isWhiteTurn) {
        while(true) {
            System.out.println("Enter source row and column");

            int sourceRow = scanner.nextInt();
            int sourceColumn = scanner.nextInt();

            Cell sourceCell = new Cell(sourceRow, sourceColumn, null);

            System.out.println("Enter destination row and column");
            int destinationRow = scanner.nextInt();
            int destinationColumn = scanner.nextInt();
            Cell destinationCell = new Cell(destinationRow, destinationColumn, null);
            Move move = new Move(sourceCell, destinationCell);

            if(Move.isMoveValid(move, board, isWhiteTurn)) {
                return move;
            }

            System.out.println("Invalid move, Try again!!");
        }
    }
}
