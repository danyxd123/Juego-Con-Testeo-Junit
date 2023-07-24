package gameObjects;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChronometerTest {

    private Chronometer chronometer;

    @Before
    public void setUp() {
        chronometer = new Chronometer();
    }

    @Test
    public void testChronometerNotRunningByDefault() {
        assertFalse(chronometer.isRunning());
    }

    @Test
    public void testChronometerStartRunning() {
        chronometer.run(1000);
        assertTrue(chronometer.isRunning());
    }

    @Test
    public void testChronometerStopRunning() {
        chronometer.run(1000);
        assertTrue(chronometer.isRunning());

        chronometer.update();
        assertFalse(chronometer.isRunning());
    }

    @Test
    public void testChronometerNotRunningWhenNotStarted() {
        chronometer.update();
        assertFalse(chronometer.isRunning());
    }

    @Test
    public void testChronometerNotRunningWhenTimeNotElapsed() {
        chronometer.run(2000);
        assertTrue(chronometer.isRunning());

        chronometer.update();
        assertTrue(chronometer.isRunning());

        chronometer.update();
        assertTrue(chronometer.isRunning());
    }

    @Test
    public void testChronometerRunningWhenTimeElapsed() throws InterruptedException {
        chronometer.run(2000);
        assertTrue(chronometer.isRunning());

        chronometer.update();
        assertTrue(chronometer.isRunning());

        // Wait for the time to elapse
        Thread.sleep(2000);

        chronometer.update();
        assertFalse(chronometer.isRunning());
    }
}


