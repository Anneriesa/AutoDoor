package org.max;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testGetName() {
        Player player = new Player("Alice", true);
        assertEquals("Alice", player.getName());
    }

    @Test
    public void testGetRisk() {
        Player player = new Player("Alice", true);
        assertTrue(player.getRisk());

        Player player2 = new Player("Bob", false);
        assertFalse(player2.getRisk());
    }
}
