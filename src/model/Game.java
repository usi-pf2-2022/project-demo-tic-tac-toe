package model;


public class Game {

    private final Board board;
    private Player currentPlayer;
    
    
    /**
     * Create a game with default starting player.
     */
    public Game() {
        this(Player.CROSS);
    }
    
    /**
     * Create a game choosing a starting player.
     */
    public Game(Player startingPlayer) {
        board = new Board();
        currentPlayer = startingPlayer;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    public boolean move(int row, int col) {
        board.place(row, col, currentPlayer);
        if (board.won(currentPlayer)) {
            return true;
        }
        return false;
    }
    
}
