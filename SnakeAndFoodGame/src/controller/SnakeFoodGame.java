package controller;

import MovementStrategyPackage.HumanPlayerStrategy;
import MovementStrategyPackage.MovementStrategy;
import utilityClasses.Board;
import utilityClasses.Direction;
import utilityClasses.Food;
import utilityClasses.Snake;

import java.util.Scanner;

public class SnakeFoodGame implements BoardGame{
    private Board board;
    private int score;

    private boolean isGameOver;
    private final Scanner scanner = new Scanner(System.in);

    public SnakeFoodGame(Board board, MovementStrategy movementStrategy) {
        this.board = board;
        this.score = 0;
        this.isGameOver = false;
    }

    @Override
    public void play() {
        while(!isGameOver) {
            displayGameScore();

            System.out.println("Enter move (U/D/L/R) or Q to quit");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("Q")) {
                System.out.println("Game ended by player with final score - " + score);
                isGameOver = true;
                continue;
            }

            Direction direction = Direction.fromCode(input);
            if(direction == null) {
                System.out.println("Invalid direction");
                continue;
            }

            score = board.makeMove(direction);

            if(score == -1) {
                System.out.println("Game over!! You hit the wall or yourself");
                int finalScore = board.getSnake().getBody().size() - 1;
                System.out.println("Final score: " + finalScore);
                isGameOver = true;
            }
        }

        scanner.close();
        System.out.println("Thanks for playing!");
    }

    private void displayGameScore() {
        System.out.println("Score: " + score);
    }
}
