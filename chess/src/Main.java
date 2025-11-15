//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome to chess game!");


    }
}


/*
1. each player has 16 pieces
2. list of pieces -
        1 king - moves 1 square in any direction
        1 queen - can move any number of squares in any direction
        2 bishops - diagonally any no of squares
        2 knights - moves in L shape - 2 square in any direction and 1 perpendicular
        2 rooks - horizontally/ vertically any no of squares
        8 pawns - moves 1 square forward but captures diagonally - on 1st move it can move 2 steps forward

 3. Objective - checkmate the opponent king
 4. 8*8 grid
 5. white always moves first

 6. Special moves
        Castling: the king moves 2 squares towards the rook
                   the rook moves over the king to the adjacent square

        en-pesant - a special pawn capture move - in first turn pawn moved 2 steps forward adjacent to the opposite pawn so it can be captured by the opponent pawn moving diagonally
        Pawn Promotion - if pawn reaches far end of the board it can be converted to any piece(usually its a queen)

 7. Winning condition
       1. Checkmate
       2. Stalemate - a player has no legal moves and the king is not in check - results in a draw



 Entities -
 1. Player
 2. Piece
 3. Piece Type - Enum
 4. Board
 5. BoardGameInterface
 6. ChessGame
 7. Move

 Strategy pattern for player move - human or AI
 piece movement strategy
 singleton pattern for board - don't use because then we cannot run multiple chess games together
 factory pattern for piece creation
 */