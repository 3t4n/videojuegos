package Factory;
import java.awt.Color.*;
import java.awt.*;
import java.util.*;

public class circleFactory
{
	private int cantidad;
	public circleFactory()
	{
		cantidad = 0;
	}
	public ArrayList<Entity> bulkProduction()
	{
		ArrayList<Entity> ret = new ArrayList<Entity>();
		for(int i = 0; i<cantidad; i++)
		{
			ret.add(new Circulo());
		}
		reset();
		return ret;
	}
	public void increaseProduction()
	{
		cantidad++;
	}
	public void decreaseProduction()
	{
		cantidad--;
		cantidad  = cantidad<0?0:cantidad;
	}
	public void reset(){
		cantidad = 0;
	}
	public int getCantidad()
	{
		return cantidad;
	}
}

