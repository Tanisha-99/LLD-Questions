import java.util.ArrayList;
import java.util.Scanner;

public class ChessGame implements BoardGame{

    private Board board;
    private Player whitePlayer;
    private Player blackPlayer;
    private boolean isWhiteTurn;
    private GameState gameState;

    //can maintain game log
    private ArrayList<Move> gameLogs;

    public ChessGame(Board board, Player whitePlayer, Player blackPlayer) {
        this.board = board;
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.isWhiteTurn = true;
        this.gameState = GameState.IN_PROGRESS;
        this.gameLogs = new ArrayList<>();
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        while(gameState == GameState.IN_PROGRESS) {
            Player currentPlayer = isWhiteTurn ? whitePlayer : blackPlayer;
            System.out.println("This is " + currentPlayer.getName() + "'s turn");

            Move move = currentPlayer.makeMove(board);

            board.makeMove(move, currentPlayer); // check status as well in this function itself
        }

        System.out.println("Game Over with status as - " + gameState.toString());
    }
}
