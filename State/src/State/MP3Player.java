package State;
import java.awt.*;
import java.awt.event.*;
public class MP3Player
{
	private State state;

	public MP3Player()
	{
		this.state = new offState();
	}
	public void handleInput()
	{
		if (Global.teclado.justPressed(KeyEvent.VK_SPACE))
		{
			this.state.pressPlay(this);
		}	
		if (Global.teclado.justPressed(KeyEvent.VK_O))
		{
			this.state.pressOn(this);
		}
	
	}
	public void setState(State state)
	{
		this.state=state;
	}
	public void render(Graphics g)
	{
		this.state.render(g);
	}
}
