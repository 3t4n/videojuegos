package Factory.Screens;
import java.awt.*;
import Factory.*;
import java.awt.event.*;
import java.util.*;

public class Game extends Screen
{
	private ArrayList<Entity> entidades;
	private int x=0;
	private int y=0;
	public Game(GameLoop contexto)
	{
		super(contexto);
		entidades = new ArrayList<Entity>();
	}
	@Override
	public void handleInput()
	{
		if (Global.teclado.justPressed(KeyEvent.VK_PLUS))
			Global.circuloF.increaseProduction();			   if (Global.teclado.justPressed(KeyEvent.VK_MINUS))
			Global.circuloF.increaseProduction();	
		if (Global.teclado.justPressed(KeyEvent.VK_ENTER))
			entidades.addAll(Global.circuloF.bulkProduction());	
	}

	public void update()
	{
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		g.setColor(Color.black);
		ListIterator<Entity> litr = entidades.listIterator();
		while (litr.hasNext()) {
			Entity element = litr.next();
			element.render(g);
		}

		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		g.drawString("Use  el caracter + y - para aumentar/disminuir la cantidad de circulos a fabricar, usa enter para fabricar", 10, 20);
		g.drawString("Cantidad a fabricar: " + Global.circuloF.getCantidad(), 10, 40);
	}
}
