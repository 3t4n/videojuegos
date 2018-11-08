package Observer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

public class Rectangulo extends Observable{
  private int x;
	private int y;
	private Color c;
	public Rectangle rect;
  private int width=50;
  private int height=25;

  public Rectangulo (int x, int y,int width, int height){
    this.x=x;
    this.y=y;
    this.c=Color.blue;
    this.rect=new Rectangle(x,y,width,height);
  }

  public void draw(Graphics g){
    g.setColor(c);
    g.fillRect(x,y,width,height);
  }

	public Rectangle getRectangle(){
		return rect;
	}

  public void move(int x, int y){
    setX(x);
    setY(y);
  }

  public void setX(int n){
    this.x+=n;
    rect.setLocation(x,y);
    setChanged();
    notifyObservers();
  }
  public void setY(int n){
    this.y+=n;
    rect.setLocation(x,y);
    setChanged();
    notifyObservers();
  }

}
