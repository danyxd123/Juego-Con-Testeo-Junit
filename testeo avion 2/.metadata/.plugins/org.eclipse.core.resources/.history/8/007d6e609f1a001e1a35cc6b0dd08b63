package gameObjects;

import graphics.Assets;
import graphics.Sound;
import math.Vector2D;
import org.junit.Before;
import org.junit.Test;
import states.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MovingObjectTest {

    private MovingObject movingObject;
    private Vector2D position;
    private Vector2D velocity;
    private double maxVel;
    private BufferedImage texture;
    private GameState gameState;
    private int width;
    private int height;
    private Sound explosion;

    @Before
    public void setUp() {
        position = new Vector2D(100, 200);
        velocity = new Vector2D(1, 0);
        maxVel = 5.0;
        texture = mock(BufferedImage.class);
        gameState = mock(GameState.class);
        width = 50;
        height = 50;
        explosion = mock(Sound.class);

        movingObject = new MovingObject(position, velocity, maxVel, texture, gameState) {
            @Override
            public void update(float dt) {
                // Empty implementation for testing purposes
            }

            @Override
            public void draw(Graphics g) {
                // Empty implementation for testing purposes
            }
        };
        movingObject.setWidth(width);
        movingObject.setHeight(height);
        movingObject.setExplosion(explosion);
    }

    @Test
    public void testCollidesWith_NoCollision() {
        // Set up
        ArrayList<MovingObject> movingObjects = new ArrayList<>();
        movingObjects.add(movingObject);
        when(gameState.getMovingObjects()).thenReturn(movingObjects);
        movingObject.setWidth(50);

        // Call the method
        movingObject.collidesWith();

        // Verify the expected behavior
        assertTrue(movingObject.isDead());
    }

    @Test
    public void testCollidesWith_Collision() {
        // Set up
        ArrayList<MovingObject> movingObjects = new ArrayList<>();
        movingObjects.add(movingObject);
        movingObjects.add(mock(MovingObject.class));
        when(gameState.getMovingObjects()).thenReturn(movingObjects);
        movingObject.setWidth(50);
        MovingObject otherObject = movingObjects.get(1);
        otherObject.setWidth(50);
        Vector2D center = new Vector2D(position.getX() + width / 2, position.getY() + height / 2);
        when(otherObject.getCenter()).thenReturn(center);

        // Call the method
        movingObject.collidesWith();

        // Verify the expected method calls and behavior
        verify(explosion).play();
        assertTrue(movingObject.isDead());
        assertTrue(otherObject.isDead());
    }

    @Test
    public void testObjectCollision_WithPlayer() {
        // Set up
        Player player = mock(Player.class);
        PowerUp powerUp = mock(PowerUp.class);
        movingObject.setWidth(50);
        powerUp.setWidth(50);
        when(player.isSpawning()).thenReturn(false);

        // Call the method
        movingObject.objectCollision(player, powerUp);

        // Verify the expected method calls and behavior
        verify(powerUp).executeAction();
        verify(powerUp).Destroy();
        assertFalse(movingObject.isDead());
        verify(player).Destroy();
        assertTrue(player.isDead());
    }

    @Test
    public void testObjectCollision_WithMeteor() {
        // Set up
        Meteor meteor = mock(Meteor.class);
        movingObject.setWidth(50);
        meteor.setWidth(50);

        // Call the method
        movingObject.objectCollision(meteor, movingObject);

        // Verify the expected behavior
        assertFalse(movingObject.isDead());
        assertFalse(meteor.isDead());
    }
}
