package gameObjects;

import graphics.Assets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PowerUpTypesTest {

    @Test
    public void testPowerUpTypes_Shield() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.SHIELD;

        // Verify the expected values
        assertEquals("SHIELD", powerUpType.text);
        assertEquals(Assets.shield, powerUpType.texture);
    }

    @Test
    public void testPowerUpTypes_Life() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.LIFE;

        // Verify the expected values
        assertEquals("+1 LIFE", powerUpType.text);
        assertEquals(Assets.life, powerUpType.texture);
    }

    @Test
    public void testPowerUpTypes_ScoreX2() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.SCORE_X2;

        // Verify the expected values
        assertEquals("SCORE x2", powerUpType.text);
        assertEquals(Assets.doubleScore, powerUpType.texture);
    }

    @Test
    public void testPowerUpTypes_FasterFire() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.FASTER_FIRE;

        // Verify the expected values
        assertEquals("FAST FIRE", powerUpType.text);
        assertEquals(Assets.fastFire, powerUpType.texture);
    }

    @Test
    public void testPowerUpTypes_ScoreStack() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.SCORE_STACK;

        // Verify the expected values
        assertEquals("+1000 SCORE", powerUpType.text);
        assertEquals(Assets.star, powerUpType.texture);
    }

    @Test
    public void testPowerUpTypes_DoubleGun() {
        // Call the constructor
        PowerUpTypes powerUpType = PowerUpTypes.DOUBLE_GUN;

        // Verify the expected values
        assertEquals("DOUBLE GUN", powerUpType.text);
        assertEquals(Assets.doubleGun, powerUpType.texture);
    }
}
