package model;


public class Board {

    public static final int SIZE = 3;
    
    private final Player[][] cells;
    
    
    public Board() {
        cells = new Player[SIZE][SIZE];
    }
    
    public boolean isEmpty(int row, int col) {
        return cells[row][col] == null;
    }
    
    public void place(int row, int col, Player player) {
        cells[row][col] = player;
    }
    
    public boolean won(Player player) {
        return ownRow(player) || 
            ownCol(player) || 
            ownMajorDiagonal(player) || 
            ownMinorDiagonal(player);
    }
    
    public boolean ownRow(Player player) {
        for (int row = 0; row < SIZE; row++) {
            if (ownRow(player, row)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean ownRow(Player player, int row) {
        Player first = cells[row][0];
        for (int col = 1; col < SIZE; col++) {
            if (cells[row][col] != first) {
                return false;
            }
        }
        return true;
    }
    
    public boolean ownCol(Player player) {
        for (int col = 0; col < SIZE; col++) {
            if (ownCol(player, col)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean ownCol(Player player, int col) {
        Player first = cells[0][col];
        for (int row = 1; row < SIZE; row++) {
            if (cells[row][col] != first) {
                return false;
            }
        }
        return true;
    }
    
    public boolean ownMajorDiagonal(Player player) {
        Player first = cells[0][0];
        for (int i = 1; i < SIZE; i++) {
            if (cells[i][i] != first) {
                return false;
            }
        }
        return true;
    }
    
    public boolean ownMinorDiagonal(Player player) {
        Player first = cells[0][SIZE-1];
        for (int i = 1; i < SIZE; i++) {
            if (cells[i][SIZE-1-i] != first) {
                return false;
            }
        }
        return true;
    }
    
}
