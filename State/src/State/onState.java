package State;
import java.awt.*;

public class onState implements State
{
	private boolean playing;
	@Override
	public void pressPlay(MP3Player context)
	{
		this.playing = this.playing?false:true;
	}
	@Override
	public void pressOn(MP3Player context)
	{
		context.setState(new offState());
	}	
	@Override
	public void render(Graphics g)
	{
		g.drawString("Reproductor Prendido",10,40);
		g.drawString("Reproduciendo Musica? " + this.playing,10,60);

	}
}

