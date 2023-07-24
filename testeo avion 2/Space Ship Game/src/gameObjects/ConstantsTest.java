package gameObjects;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantsTest {

    @Test
    public void testFrameDimensions() {
        assertEquals(1000, Constants.WIDTH);
        assertEquals(600, Constants.HEIGHT);
    }

    @Test
    public void testPlayerProperties() {
        assertEquals(300, Constants.FIRERATE);
        assertEquals(0.1, Constants.DELTAANGLE, 0.001);
        assertEquals(0.2, Constants.ACC, 0.001);
        assertEquals(7.0, Constants.PLAYER_MAX_VEL, 0.001);
        assertEquals(200, Constants.FLICKER_TIME);
        assertEquals(3000, Constants.SPAWNING_TIME);
        assertEquals(3000, Constants.GAME_OVER_TIME);
    }

    // Agrega más pruebas para las demás constantes...

}
