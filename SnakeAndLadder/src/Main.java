import model.Ladder;
import model.Player;
import model.Snake;
import services.SnakeAndLadderService;
import services.impl.SnakeAndLadderServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to the Snake & Ladder Game!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of snakes");
        int numberOfSnakes = scanner.nextInt();
        List<Snake> snakes = new ArrayList<Snake>();
        for (int i = 0; i < numberOfSnakes; i++) {
            snakes.add(new Snake(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter the number of ladders");
        int numberOfLadders = scanner.nextInt();
        List<Ladder> ladders = new ArrayList<Ladder>();
        for (int i = 0; i < numberOfSnakes; i++) {
            ladders.add(new Ladder(scanner.nextInt(), scanner.nextInt()));
        }

        System.out.println("Enter the number of players");
        int noOfPlayers = scanner.nextInt();
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < noOfPlayers; i++) {
            players.add(new Player(scanner.next(), scanner.next()));
        }

        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderServiceImpl();

        ((SnakeAndLadderServiceImpl) snakeAndLadderService).setPlayers(players);
        ((SnakeAndLadderServiceImpl) snakeAndLadderService).setSnakes(snakes);
        ((SnakeAndLadderServiceImpl) snakeAndLadderService).setLadders(ladders);

        snakeAndLadderService.startGame();
    }
}