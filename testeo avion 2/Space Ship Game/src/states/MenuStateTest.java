package states;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.awt.Graphics;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gameObjects.Constants;
import graphics.Assets;
import ui.Action;
import ui.Button;

public class MenuStateTest {

    private MenuState menuState;

    @BeforeEach
    public void setUp() {
        menuState = new MenuState();
    }

    @Test
    public void testMenuState() {
        ArrayList<Button> buttons = menuState.getButtons();

        assertNotNull(buttons);
        assertEquals(3, buttons.size());

        Button playButton = buttons.get(0);
        assertNotNull(playButton);
        assertEquals(Constants.WIDTH / 2 - Assets.greyBtn.getWidth() / 2, playButton.getX());
        assertEquals(Constants.HEIGHT / 2 - Assets.greyBtn.getHeight() * 2, playButton.getY());
        assertEquals(Constants.PLAY, playButton.getText());
        assertNotNull(playButton.getAction());

        Button exitButton = buttons.get(1);
        assertNotNull(exitButton);
        assertEquals(Constants.WIDTH / 2 - Assets.greyBtn.getWidth() / 2, exitButton.getX());
        assertEquals(Constants.HEIGHT / 2 + Assets.greyBtn.getHeight() * 2, exitButton.getY());
        assertEquals(Constants.EXIT, exitButton.getText());
        assertNotNull(exitButton.getAction());

        Button scoreButton = buttons.get(2);
        assertNotNull(scoreButton);
        assertEquals(Constants.WIDTH / 2 - Assets.greyBtn.getWidth() / 2, scoreButton.getX());
        assertEquals(Constants.HEIGHT / 2, scoreButton.getY());
        assertEquals(Constants.HIGH_SCORES, scoreButton.getText());
        assertNotNull(scoreButton.getAction());
    }
}

