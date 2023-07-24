package states;

import java.awt.Graphics;

public abstract class State {
	
	private static State currentState = null;
	protected static boolean updateCalled = false;
	protected static boolean drawCalled = false;
	
	public static State getCurrentState() {
		return currentState;
	}
	
	public static void changeState(State newState) {
		currentState = newState;
	}
	
	public abstract void update(float dt);
	public abstract void draw(Graphics g);
	
	public static boolean isUpdateCalled() {
		return updateCalled;
	}
	
	public static boolean isDrawCalled() {
		return drawCalled;
	}
	
	public static void resetFlags() {
		updateCalled = false;
		drawCalled = false;
	}

	public void draw(FakeGraphics graphics) {
		// TODO Auto-generated method stub
		
	}
}

