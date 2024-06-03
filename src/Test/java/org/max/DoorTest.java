package org.max;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DoorTest {

    @Test
    public void testIsPrize() {
        Door doorWithPrize = new Door(true);
        assertTrue(doorWithPrize.isPrize());

        Door doorWithoutPrize = new Door(false);
        assertFalse(doorWithoutPrize.isPrize());
    }
}
