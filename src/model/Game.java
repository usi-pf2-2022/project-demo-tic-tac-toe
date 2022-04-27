package model;


public class Game {

    private final Board board;
    private Player currentPlayer;
    
    
    public Game() {
        board = new Board();
        currentPlayer = Player.CROSS;
    }
    
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    /**
     * Set the move for the currentPlayer at a given row and column.
     *
     *
     * @param row The row we want to place our mark at
     * @param col The column we want to place our mark at
     * @return true if after placing this mark, the current Player has won; false otherwise
     */
    public boolean move(int row, int col) {
        board.place(row, col, currentPlayer);
        if (board.won(currentPlayer)) {
            return true;
        }
        return false;
    }
    
}
