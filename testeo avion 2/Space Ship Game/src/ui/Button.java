package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.Assets;
import graphics.Text;
import input.MouseInput;
import math.Vector2D;

public class Button {

    private BufferedImage mouseOutImg;
    private BufferedImage mouseInImg;
    private boolean mouseIn;
    private Rectangle boundingBox;
    private Action action;
    private String text;
    private boolean actionPerformed;

    public Button(Object greyBtn, BufferedImage mouseInImg, int x, int y, String text, Action action) {
        this.mouseInImg = mouseInImg;
        this.mouseOutImg = (BufferedImage) greyBtn;
        this.text = text;
        boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), mouseInImg.getHeight());
        this.action = action;
    }

    public void update() {
        mouseIn = boundingBox.contains(MouseInput.X, MouseInput.Y);

        if (mouseIn && MouseInput.MLB) {
            action.doAction();
            actionPerformed = true;
        }
    }

    public void draw(Graphics g) {
        if (mouseIn) {
            g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
        }

        int textX = (int) (boundingBox.getX() + boundingBox.getWidth() / 2 - Text.getTextWidth(text, Assets.fontMed) / 2);
        int textY = (int) (boundingBox.getY() + boundingBox.getHeight() / 2 + Text.getTextHeight(text, Assets.fontMed) / 2);

        Text.drawText(g, text, new Vector2D(textX, textY), true, Color.BLACK, Assets.fontMed);
    }

    public boolean isActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(boolean actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

	public void setBoundingBox(Rectangle boundingBox2) {
		// TODO Auto-generated method stub
		
	}

	public void setMouseIn(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public Object getTextWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTextHeight() {
		// TODO Auto-generated method stub
		return null;
	}

	public void click() {
		// TODO Auto-generated method stub
		
	}

	public Integer getY() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getNormalImage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getAction() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getHoverImage() {
		// TODO Auto-generated method stub
		return null;
	}
}

