package State.Screens;
import java.awt.*;
import State.*;
import java.awt.event.*;

public class Game extends Screen
{
	private int x=0;
	private int y=0;
	MP3Player test;
	public Game(GameLoop contexto)
	{
		super(contexto);
		test = new MP3Player();
	}
	@Override
	public void handleInput()
	{
	test.handleInput();
	}

	public void update()
	{
	}
	public void render(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,800,800);
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		g.drawString("Prende/apaga el 'reproductor mp3' con la letra o y comienza/deten la música con space",10,20);
		test.render(g);
	}
}
