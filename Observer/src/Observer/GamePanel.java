package Observer;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Rectangle;

public class GamePanel extends JPanel implements Runnable{
    private static final int PWIDTH=500;
    private static final int PHEIGHT=500;//tamaño de mi panel


    private Graphics dbg;
    private Image dbImage=null;

    private Thread animator; //para la animacion
    private volatile boolean running=false;
    private volatile boolean gameOver=false;
    private volatile boolean isPaused=false;
    private Random r=new Random();
    private Color c = new Color(0,0,0);
    private ArrayList<Circle> circulos=new ArrayList<Circle>();
    private Rectangulo rect;

    public GamePanel(){
      setBackground(Color.white);
      setPreferredSize( new Dimension(PWIDTH, PHEIGHT));
      setFocusable(true);
      requestFocus();
      readyForTermination();
      addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent e){
          testPress(e.getX(),e.getY()); }
      });
      rect=new Rectangulo(250,250,50,25);
      for (int i=0; i<3;i++){
        Random r=new Random();
        int  x = r.nextInt(480) + 1;
        int  y = r.nextInt(480) + 1;
        circulos.add(new Circle(x,y,rect));
        rect.addObserver(circulos.get(i));
      }
    }

    public void gameRender(){
        if(dbImage==null){
            setPreferredSize( new Dimension(PWIDTH, PHEIGHT));
            dbImage=createImage(PWIDTH,PHEIGHT);
            if (dbImage==null){
                System.out.println("dbImage is null");
                return;
            }else{
                dbg=dbImage.getGraphics();
            }
        }
        dbg.setColor(Color.white);
        dbg.fillRect(0,0,PWIDTH,PHEIGHT);
        dbg.setColor(Color.black);
        dbg.drawString("Usa las flechas, observer se usa aqui para detectar las colisiones",40,80);
	rect.draw(dbg);
        for (int i=0; i<3;i++){
          circulos.get(i).draw(dbg);
        }

    }

    private void gameOverMessage(){
		Graphics g;
		g = this.getGraphics();
		g.drawString("GameOver", 10, 10);
	}

    public void addNotify(){
        super.addNotify();
        startGame();
    }

    private void startGame(){
        if(animator==null||!running){
            animator=new Thread(this);
            animator.start();
        }
    }

    public void stopGame(){
        running=false;
    }
    private void paintScreen(){
        Graphics g;
        try{
            g=this.getGraphics();
            if((g!=null)&&dbImage!=null){
                g.drawImage(dbImage,0,0,null);
            }
            g.dispose();
        }catch (Exception e){
            System.out.println("Graphics error" + e);
        }
    }

    //Clase anonima para leer las teclas de
    private void readyForTermination(){
		addKeyListener( new KeyAdapter(){//Clase anonima para leer las teclas de
			public void keyPressed(KeyEvent e){ //Sobrecarga para leer teclas
				int keyCode = e.getKeyCode(); //Se convierte la tecla a valor entero ASCII
				if((keyCode == KeyEvent.VK_ESCAPE)||(keyCode == KeyEvent.VK_Q)||(keyCode == KeyEvent.VK_END)||((keyCode == KeyEvent.VK_C) && e.isControlDown()) ){
					running = false;
				}//Se deja de correr el programa si el usuario presiona alguna tecla de escape
				eval(keyCode);
			}
		});
	}

	private void eval(int k){
		if(k == KeyEvent.VK_RIGHT){
      rect.move(5,0);
		}
		if(k == KeyEvent.VK_LEFT){
      rect.move(-5,0);
		}
		if(k == KeyEvent.VK_UP){
      rect.move(0,-5);
		}
		if(k == KeyEvent.VK_DOWN){
      rect.move(0,5);
		}
	}

  private void testPress(int x, int y){
		if(!gameOver && !isPaused){

			//Whatever
		}
	}

    public void run(){
        running=true;
        while(running){
            gameUpdate();
            gameRender();
            paintScreen();
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){}
        }
        System.exit(0);
    }

    private void gameUpdate(){
        if(!gameOver||!isPaused){
            //se actualiza todo aqui
        }
    }


}
