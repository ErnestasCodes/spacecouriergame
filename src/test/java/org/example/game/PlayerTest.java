package org.example.game;

import org.example.player.Player;
import org.example.model.Planet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void testFuelDecreasesAfterMove() {
        Planet start = new Planet("Astra");
        Player player = new Player(start, 10);
        player.moveTo(new Planet("Borealis"), 3);
        assertEquals(7, player.getFuel());
    }

    @Test
    public void testHasFuel() {
        Player player = new Player(new Planet("Astra"), 0);
        assertFalse(player.hasFuel());
    }
}
