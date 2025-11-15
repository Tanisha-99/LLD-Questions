public class Player {
    private String name;
    private Boolean isWhite;
    private PlayerStrategy playerStrategy;

    public Player(String name, Boolean isWhite, PlayerStrategy playerStrategy) {
        this.name = name;
        this.isWhite = isWhite;
        this.playerStrategy = playerStrategy;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsWhite() {
        return isWhite;
    }

    public Move makeMove(Board board) {
        return playerStrategy.makeMove(board, isWhite);
    }
}
