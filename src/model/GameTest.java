package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GameTest {

    @Test
    public void testStartingPlayerIsCross() {
        Game g = new Game();
        assertEquals(Player.CROSS, g.getCurrentPlayer());
    }

}
