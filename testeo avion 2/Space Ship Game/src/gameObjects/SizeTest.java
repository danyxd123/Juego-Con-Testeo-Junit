package gameObjects;

import graphics.Assets;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class SizeTest {

    @Test
    public void testSize_Big() {
        // Call the constructor
        Size size = Size.BIG;

        // Verify the expected values
        assertEquals(2, size.quantity);
        assertArrayEquals(Assets.meds, size.textures);
    }

    @Test
    public void testSize_Med() {
        // Call the constructor
        Size size = Size.MED;

        // Verify the expected values
        assertEquals(2, size.quantity);
        assertArrayEquals(Assets.smalls, size.textures);
    }

    @Test
    public void testSize_Small() {
        // Call the constructor
        Size size = Size.SMALL;

        // Verify the expected values
        assertEquals(2, size.quantity);
        assertArrayEquals(Assets.tinies, size.textures);
    }

    @Test
    public void testSize_Tiny() {
        // Call the constructor
        Size size = Size.TINY;

        // Verify the expected values
        assertEquals(0, size.quantity);
        assertNull(size.textures);
    }
}
