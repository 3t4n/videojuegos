package ciclo.Screens;
import java.awt.*;
import ciclo.*;
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
		g.fillOval(x,y,10,10);
	}
}
