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
        return ownSequence(player, row, 0, 0, 1);
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
        return ownSequence(player, 0, col, 1, 0);
    }
    
    public boolean ownMajorDiagonal(Player player) {
        return ownSequence(player, 0, 0, 1, 1);
    }
    
    public boolean ownMinorDiagonal(Player player) {
        return ownSequence(player, 0, SIZE - 1, 1, -1);
    }
    
    public boolean ownSequence(Player player, int startRow, int startCol, int deltaRow, int deltaCol) {
        for (int i = 0; i < SIZE; i++) {
            if (cells[startRow + deltaRow * i][startCol + deltaCol * i] != player) {
                return false;
            }
        }
        return true;
    }
    
}
