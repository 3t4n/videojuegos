package Singleton;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import Singleton.*;
import Singleton.Screens.*;

public class GameLoop extends JComponent implements Runnable
{
	private Image bf;
	private Screen pantalla;
	private int numActs = 0;
	private int lag = 0;
	private int numRenders = 0;
	private int numUpdates = 0;
	private int duracion = 0;
	private boolean pausa = false;
	public  static long FPS = 1000/10;
	public  final int altura = 600;
	public  final int anchura = 800;
	

	public GameLoop()
	{
		super();
		setFocusable(true);
		setIgnoreRepaint(true);
		Global.teclado = new KeyHandler();
		this.pantalla = new Game(this);
		Global.pantalla = this.pantalla;
		addKeyListener(Global.teclado);
		Global.chron = new Chronometer();
	}
	@Override
	public void run()
	{
		long previo = System.currentTimeMillis();
		Image buffer = createImage(anchura,altura);

		while(true){
			long actual = System.currentTimeMillis();
			long pasado = actual - previo;
			previo = actual;
			lag += pasado;
			duracion += pasado;
			
			if(duracion>3000)
			{
				duracion=0;
				numRenders = 0;
				numActs = 0;
			}
			while(lag>=FPS)
			{
				handleInput();
				if(!pausa)
				{
					update();
					numActs++;
				}
				Global.teclado.update();
				lag -= FPS;
			}
			this.pantalla.render(buffer.getGraphics());
			getGraphics().drawImage(buffer, 0,0, this);
		}
	}
	public void setScreen(Screen s)
	{
		this.pantalla = s;
	}

	public void setPaused(boolean b)
	{
		this.pausa = b;
	}
	public boolean getPaused()
	{
		return this.pausa;
	}

	public void update()
	{
		this.pantalla.update();
	}

	public Image getBuffer()
	{
		return this.bf;
	}

	public void setBuffer(Image b)
	{
		this.bf = b;
	}

	public void handleInput()
	{
		this.pantalla.handleInput();
	}
	    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(anchura,altura);
    }


}

