package gameObjects;

import graphics.Assets;
import graphics.Sound;
import input.KeyBoard;
import math.Vector2D;
import org.junit.Before;
import org.junit.Test;
import states.GameState;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PlayerTest {

    private Player player;
    private Vector2D position;
    private Vector2D velocity;
    private double maxVel;
    private GameState gameState;
    private Sound shoot;
    private Sound loose;
    private Animation shieldEffect;

    @Before
    public void setUp() {
        position = new Vector2D(100, 200);
        velocity = new Vector2D(1, 0);
        maxVel = 5.0;
        gameState = mock(GameState.class);
        shoot = mock(Sound.class);
        loose = mock(Sound.class);
        shieldEffect = mock(Animation.class);

        player = new Player(position, velocity, maxVel, mock(BufferedImage.class), gameState) {
            @Override
            public void update(float dt) {
                // Empty implementation for testing purposes
            }

            @Override
            public void draw(Graphics g) {
                // Empty implementation for testing purposes
            }
        };
        player.setShoot(shoot);
        player.setLoose(loose);
        player.setShieldEffect(shieldEffect);
    }

    @Test
    public void testUpdate_NoShoot() {
        // Set up
        KeyBoard.SHOOT = false;
        float dt = 0.1f;

        // Call the method
        player.update(dt);

        // Verify the expected behavior
        verifyZeroInteractions(shoot);
    }

    @Test
    public void testUpdate_Shoot() {
        // Set up
        KeyBoard.SHOOT = true;
        float dt = 0.1f;

        // Call the method
        player.update(dt);

        // Verify the expected method calls and behavior
        verify(shoot).play();
        assertEquals(0, player.getFireRate(), 0.001);
    }

    @Test
    public void testUpdate_ShieldOn() {
        // Set up
        player.setShieldOn(true);
        player.setShieldTime(500);
        float dt = 0.1f;

        // Call the method
        player.update(dt);

        // Verify the expected behavior
        assertEquals(0.1, player.getShieldTime(), 0.001);
        verify(shieldEffect).update(dt);
    }

    @Test
    public void testSetShield() {
        // Call the method
        player.setShield();

        // Verify the expected behavior
        assertTrue(player.isShieldOn());
        assertEquals(0, player.getShieldTime(), 0.001);
    }

    @Test
    public void testSetDoubleScore() {
        // Call the method
        player.setDoubleScore();

        // Verify the expected behavior
        assertTrue(player.isDoubleScoreOn());
        assertEquals(0, player.getDoubleScoreTime(), 0.001);
    }

    @Test
    public void testSetFastFire() {
        // Call the method
        player.setFastFire();

        // Verify the expected behavior
        assertTrue(player.isFastFireOn());
        assertEquals(0, player.getFastFireTime(), 0.001);
    }

    @Test
    public void testSetDoubleGun() {
        // Call the method
        player.setDoubleGun();

        // Verify the expected behavior
        assertTrue(player.isDoubleGunOn());
        assertEquals(0, player.getDoubleGunTime(), 0.001);
    }

    @Test
    public void testDestroy_NotSpawning() {
        // Set up
        player.setSpawning(false);

        // Call the method
        player.Destroy();

        // Verify the expected method calls and behavior
        verify(gameState).playExplosion(position);
        verify(loose).play();
        verify(gameState).subtractLife(position);
        verifyNoMoreInteractions(gameState, loose);
        assertFalse(player.isSpawning());
    }

    @Test
    public void testDestroy_Spawning() {
        // Set up
        player.setSpawning(true);

        // Call the method
        player.Destroy();

        // Verify the expected method calls and behavior
        verify(gameState).playExplosion(position);
        verify(loose).play();
        verify(gameState).subtractLife(position);
        verify(gameState).gameOver();
        verifyNoMoreInteractions(gameState, loose);
        assertFalse(player.isSpawning());
        verify(player).resetValues();
    }

    @Test
    public void testResetValues() {
        // Set up
        player.setAngle(1.5);
        player.setVelocity(new Vector2D(2, 3));
        player.setPosition(new Vector2D(300, 400));

        // Call the method
        player.resetValues();

        // Verify the expected behavior
        assertEquals(0, player.getAngle(), 0.001);
        assertEquals(new Vector2D(), player.getVelocity());
        assertEquals(GameState.PLAYER_START_POSITION, player.getPosition());
    }
}
