package gameObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

import math.Vector2D;

public class GameObjectTest {
    private GameObject gameObject;

    @Before
    public void setUp() {
        Vector2D position = new Vector2D(10, 20);
        BufferedImage texture = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
        gameObject = new GameObjectImpl(position, texture);
    }

    @Test
    public void testGetPosition() {
        Vector2D position = gameObject.getPosition();
        assertNotNull(position);
        assertEquals(10, position.getX(), 0);
        assertEquals(20, position.getY(), 0);
    }

    @Test
    public void testSetPosition() {
        Vector2D newPosition = new Vector2D(30, 40);
        gameObject.setPosition(newPosition);
        Vector2D position = gameObject.getPosition();
        assertNotNull(position);
        assertEquals(30, position.getX(), 0);
        assertEquals(40, position.getY(), 0);
    }

    // Implementa más pruebas de acuerdo a los métodos de la clase GameObject

    private static class GameObjectImpl extends GameObject {
        public GameObjectImpl(Vector2D position, BufferedImage texture) {
            super(position, texture);
        }

        @Override
        public void update(float dt) {
            // Implementa la lógica de actualización para las pruebas si es necesario
        }

        @Override
        public void draw(Graphics g) {
            // Implementa la lógica de dibujo para las pruebas si es necesario
        }
    }
}

