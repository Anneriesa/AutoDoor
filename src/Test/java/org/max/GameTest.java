package org.max;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    private Player player;
    private List<Door> doors;
    private Game game;

    @BeforeEach
    public void setUp() {
        player = new Player("Alice", false);
        doors = new ArrayList<>();
        doors.add(new Door(true));  // Door 0 has the prize
        doors.add(new Door(false)); // Door 1 does not have the prize
        game = new Game(player, doors);
    }

    @Test
    public void testRoundWithoutRisk() {
        Door selectedDoor = game.round(0);
        assertTrue(selectedDoor.isPrize());

        selectedDoor = game.round(1);
        assertFalse(selectedDoor.isPrize());
    }

    @Test
    public void testRoundWithRisk() {
        player = new Player("Alice", true);
        game = new Game(player, doors);

        Door selectedDoor = game.round(1);
        assertFalse(selectedDoor.isPrize());

        // Resetting the doors and testing the other case
        doors = new ArrayList<>();
        doors.add(new Door(false));
        doors.add(new Door(true));
        game = new Game(player, doors);

        selectedDoor = game.round(1);
        assertTrue(selectedDoor.isPrize());
    }
}
