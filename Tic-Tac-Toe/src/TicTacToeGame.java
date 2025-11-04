import models.Board;
import models.Player;
import models.Position;
import models.Symbol;
import states.GameContext;
import states.GameState;
import states.OWonState;
import states.XWonState;
import strategies.PlayerStrategy;

public class TicTacToeGame implements BoardGames{

    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy, int rows, int colums){
        board = new Board(rows, colums);
        playerX = new Player(Symbol.X, playerXStrategy);
        playerO = new Player(Symbol.O, playerOStrategy);
        currentPlayer = playerX;
        gameContext = new GameContext();
    }

    @Override
    public void play() {
        do {
            board.printBoard();

            Position move = currentPlayer.makeMove(board);
            board.makeMove(move, currentPlayer.getSymbol());

            board.checkGameState(gameContext);
            switchPlayer();
        }while(!gameContext.isGameOver());

        announceResult();
    }

    public void switchPlayer(){
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        gameContext.next(false);
    }

    public void announceResult(){
        GameState state = gameContext.getCurrentGameState();

        if(state instanceof XWonState) {
            System.out.println("Player X wins !!");
        } else {
            if(state instanceof OWonState) {
                System.out.println("Player O wins !!");
            }
            else {
                System.out.println("It's a tie! !!");
            }
        }
    }
}
