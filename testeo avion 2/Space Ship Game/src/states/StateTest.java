package states;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Graphics;

public class StateTest {

    private TestState testState;
    private FakeGraphics graphics;

    @Before
    public void setUp() {
        testState = new TestState();
        graphics = new FakeGraphics();
    }

    @After
    public void tearDown() {
        State.resetFlags();
    }

    @Test
    public void testUpdate() {
        float dt = 0.1f;
        testState.update(dt);
        assertTrue("Update method should be called", State.isUpdateCalled());
    }

    @Test
    public void testDraw() {
        testState.draw(graphics);
        assertTrue("Draw method should be called", State.isDrawCalled());
    }

    private class TestState extends State {
        @Override
        public void update(float dt) {
            State.changeState(this);
            State.updateCalled = true;
        }

        @Override
        public void draw(FakeGraphics graphics) {
            State.changeState(this);
            State.drawCalled = true;
        }
    }
}

