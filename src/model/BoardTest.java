package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BoardTest {

    private static final Player X = Player.CROSS;
    private static final Player O = Player.CIRCLE;
    private static final Player E = null;


    @Test
    public void testNewBoardIsEmpty() {
        Board b = new Board();
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                assertEquals(true, b.isEmpty(row, col));
            }
        }
    }

    @Test
    public void testPlace00() {
        Board b = new Board();
        b.place(0, 0, Player.CROSS);
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (row == 0 && col == 0) {
                    assertEquals(false, b.isEmpty(row, col));
                } else {
                    assertEquals(true, b.isEmpty(row, col));
                }
            }
        }
    }

    private Board make(Player[][] cells) {
        final Board b = new Board();
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                b.place(row, col, cells[row][col]);
            }
        }
        return b;
    }

    @Test
    public void testXWinsFirstRow() {
        Board b = make(new Player[][] {{X, X, X}, {E, E, E}, {O, O, E}});
        assertTrue(b.won(Player.CROSS));
    }

    @Test
    public void testXWinsMinorDiagonal() {
        Board b = make(new Player[][] {{E, E, X}, {E, X, E}, {X, O, O}});
        assertTrue(b.won(Player.CROSS));
    }


}
