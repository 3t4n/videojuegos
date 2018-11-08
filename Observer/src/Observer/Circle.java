package Observer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.io.*;

public class Circle implements Observer{
  private int x;
	private int y;
	private Color c;
	public Rectangle rect;
  private int radio;
  private boolean print;
  private Rectangulo rectangulo;

  public Circle (int x, int y, Rectangulo rectangulo){
    this.x=x;
    this.y=y;
    this.rectangulo=rectangulo;
    this.c=Color.green;
    this.radio=25;
    print=false;
    this.rect=new Rectangle(x,y,radio,radio);
  }

  public void draw(Graphics g){
    g.setColor(c);
    g.fillRect(x,y,radio,radio);
    if(this.print){
      g.setColor(Color.black);
      g.drawString("Hay una colisión", 10, 20);
    }
  }


  public boolean collision (Rectangle r){
		Rectangle rec = this.getRectangle();
		return rec.intersects(r);
	}

	public Rectangle getRectangle(){
		return rect;
	}

  public void setX(int n){
    this.x+=n;
  }
  public void setY(int n){
    this.y+=n;
  }
  public void update(Observable obj, Object arg) {
    if(collision(((Rectangulo)obj).getRectangle())){
      this.print=true;
    }else if (!collision(((Rectangulo)obj).getRectangle())){
      this.print=false;
    }

  }
}
