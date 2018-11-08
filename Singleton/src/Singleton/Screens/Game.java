package Singleton.Screens;
import java.awt.*;
import Singleton.*;
import java.awt.event.*;

public class Game extends Screen
{
	private int x=0;
	private int y=0;
	public Game(GameLoop contexto)
	{
		super(contexto);
	}
	@Override
	public void handleInput()
	{
		if (Global.teclado.justPressed(KeyEvent.VK_SPACE)) {
			contexto.setPaused(!contexto.getPaused());
		}
		
	}

	public void update()
	{
		x+=1;
		y+=1;
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		g.fillOval(x,y,20,20);
		g.drawString("Usar Space para detener la pelota, el cronómetro usa el pattern Singleton "+Global.chron.getElapsedTime(),10,20);
		g.drawString("El input del teclado lo maneja una clase que implementa los listeners, esta clase se crea en el singleton", 10, 40);
	}
}
