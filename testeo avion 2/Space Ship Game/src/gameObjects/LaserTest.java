package gameObjects;

import math.Vector2D;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import states.GameState;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LaserTest {
    private Laser laser;

    @BeforeEach
    public void setUp() {
        Vector2D position = new Vector2D(100, 100);
        Vector2D velocity = new Vector2D(1, 0);
        double maxVel = 10;
        double angle = 0;
        BufferedImage texture = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
        GameState gameState = new GameState();
        laser = new Laser(position, velocity, maxVel, angle, texture, gameState);
    }

    @Test
    public void testUpdate() {
        float dt = 0.1f;
        Vector2D initialPosition = laser.getPosition();
        laser.update(dt);
        Vector2D expectedPosition = initialPosition.add(laser.getVelocity().scale(dt));
        Assertions.assertEquals(expectedPosition, laser.getPosition());

        // TODO: Add more test cases for different scenarios
    }

    @Test
    public void testDraw() {
        // Create a mock Graphics object for testing
        Graphics graphics = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB).getGraphics();
        laser.draw(graphics);

        // TODO: Add assertions to validate the expected behavior of the draw method
    }

    @Test
    public void testGetCenter() {
        Vector2D center = laser.getCenter();
        Vector2D expectedCenter = laser.getPosition().add(new Vector2D(laser.getWidth() / 2, laser.getWidth() / 2));
        Assertions.assertEquals(expectedCenter, center);

        // TODO: Add more test cases if necessary
    }
}

