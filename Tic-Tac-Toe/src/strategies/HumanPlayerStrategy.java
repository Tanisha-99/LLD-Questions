package strategies;

import models.Board;
import models.Position;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy {

    private Scanner scanner;
    private String playerName;

    public HumanPlayerStrategy(String playerName) {
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Position makeMove(Board board) {

        while(true) {
            System.out.printf("%s please enter your move%n", playerName);

            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Position move = new Position(row, col);

            if(board.isValidMove(move)) {
                return move;
            }

            System.out.println("Invalid move, Try again!!");
        }
    }
}
