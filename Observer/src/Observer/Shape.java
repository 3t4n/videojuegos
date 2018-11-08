package Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public abstract class Shape{
	protected int x;
	protected int y;
	protected Color c;
	public Rectangle rect;

	public abstract void draw (Graphics g);
	public abstract void move();

	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public boolean collision (Rectangle r){
		Rectangle rec = this.getRectangle();
		System.out.println(r.getX() + r.getY());
		return rec.contains(r.getX(), r.getY());
	}

	public Rectangle getRectangle(){
		return rect;
	}
}
