package Factory;
import java.awt.*;
import java.awt.color.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Circulo implements Entity
{
	private Point position;
	public Circulo()
	{
		position = new Point(ThreadLocalRandom.current().nextInt(10, 780 + 1),ThreadLocalRandom.current().nextInt(40, 380 + 1));
	}
	@Override
	public void render(Graphics g)
	{
		g.setColor(Color.black);
		g.fillOval((int)position.getX(),(int)position.getY(),10,10);
	}
}
