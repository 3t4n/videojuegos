package State;
import java.awt.*;

public class offState implements State
{
	@Override
	public void pressPlay(MP3Player context)
	{
	}
	@Override
	public void pressOn(MP3Player context)
	{
		context.setState(new onState());
	}	
	@Override
	public void render(Graphics g)
	{
		g.drawString("Reproductor Apagado",10,40);
	}
}

