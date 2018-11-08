package Singleton;

import java.awt.*;

public interface Entity
{
	//https://docs.oracle.com/javase/7/docs/api/java/awt/Point.html
	public Point getPosition();
	public void setPosition(Point p);
	public void update();
	public void render(Graphics g);
}
