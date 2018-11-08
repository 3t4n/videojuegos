package State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main
{
    public static void main(String[] argv)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Test");
                Container pane = frame.getContentPane();
                GameLoop Statejuego = new GameLoop();
                frame.getContentPane().add(Statejuego);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(true);
                frame.setVisible(true);
                new Thread(Statejuego).start();
            }
        });
    }
}

