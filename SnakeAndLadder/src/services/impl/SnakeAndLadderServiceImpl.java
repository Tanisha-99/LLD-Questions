package services.impl;

import model.Board;
import model.Ladder;
import model.Player;
import model.Snake;
import services.DiceService;
import services.SnakeAndLadderService;

import java.util.*;

public class SnakeAndLadderServiceImpl implements SnakeAndLadderService {
    private Board board;
    private int numberOfPlayers;
    private Queue<Player> players;
    private boolean isGameCompleted;

    private int numberOfDice;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleDiceRolls;

    private static final int DEFAULT_BOARD_SIZE = 100;
    private static final int DEFAULT_NUMBER_OF_DICE = 1;

    private DiceService diceService = new DiceServiceImpl();

    public SnakeAndLadderServiceImpl(int boardSize) {
        board = new Board(boardSize);
        players = new LinkedList<Player>();
        this.numberOfDice = DEFAULT_NUMBER_OF_DICE;
    }

    public SnakeAndLadderServiceImpl() {
        this(DEFAULT_BOARD_SIZE);
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRolls(boolean shouldAllowMultipleDiceRolls) {
        this.shouldAllowMultipleDiceRolls = shouldAllowMultipleDiceRolls;
    }

    public void setPlayers(List<Player> players) {
        this.players = new LinkedList<Player>();
        this.numberOfPlayers = players.size();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        for (Player player : players) {
            this.players.add(player);
            playerPieces.put(player.getId(), 0);
        }
        board.setPlayers(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        board.setSnakes(snakes);
    }

    public void setLadders(List<Ladder> ladders) {
        board.setLadders(ladders);
    }

    @Override
    public void startGame() {
        while(!isGameCompleted()) {
            int totalDiceValue = getTotalValueAfterDiceRoll();
            Player currentPlayer = players.poll();
            movePlayer(currentPlayer, totalDiceValue);

            if(hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game!!");
            }
            else {
                players.add(currentPlayer);
            }
        }
    }

    private boolean isGameCompleted() {
        int currentNumberOfPlayers = players.size();
        return currentNumberOfPlayers < numberOfPlayers;
    }

    private int getTotalValueAfterDiceRoll() {
        return diceService.rollDice(numberOfDice);
    }

    private void movePlayer(Player player, int totalDiceValue) {
        int oldPosition = board.getPlayers().get(player.getId());
        int newPosition = oldPosition + totalDiceValue;

        int boardSize = board.getSize();

        if(newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPositionAfterSnakesAndLadders(newPosition);
        }

        board.getPlayers().put(player.getId(), newPosition);

        System.out.println(player.getName() + " rolled a " + totalDiceValue + " and moved from " + oldPosition +" to " + newPosition);
    }

    private int getNewPositionAfterSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;

            for(Snake snake: board.getSnakes()) {
                if(snake.getHead() == newPosition) {
                    newPosition = snake.getTail();
                }
            }

            for(Ladder ladder: board.getLadders()) {
                if(ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        }while(newPosition != previousPosition);

        return newPosition;
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        int playerPosition = board.getPlayers().get(currentPlayer.getId());

        int winningPosition = board.getSize();

        return playerPosition == winningPosition;
    }
}
