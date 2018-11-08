package State;
import java.awt.*;

public interface State {
	public void pressPlay(MP3Player context);	
	public void pressOn(MP3Player context);	
	public void render(Graphics g);	
}
