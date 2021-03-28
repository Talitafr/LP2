import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
class RectEllipseFigApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
        ListFrame frame1 = new ListFrame();
        frame1.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Ellipse> es = new ArrayList<Ellipse>();
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    if (evt.getKeyChar() == 'e') {
                        int x = rand.nextInt(350);
                        int y = rand.nextInt(350);
                        int w = rand.nextInt(50);
                        int h = rand.nextInt(50);
                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
                        es.add(new Ellipse(x,y, w,h,fundo,contorno));
                        repaint();  // outer.repaint()
                    }
                }
            }
        );

        this.setTitle("Lista de Elipses");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        for (Ellipse e: this.es) {
            e.paint(g);
        }
    }
}


class RectEllipseFrame extends JFrame {
    Rect r1;
	Triangret t;
	Trapezio trap;
	
     RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(50,100, 100,30,Color.orange,Color.red);
        this.t = new Triangret(50,250, 100,30,Color.yellow,Color.blue);
        this.trap = new Trapezio(50,295, 100,60,45,Color.orange,Color.red);
        }

    public void paint (Graphics g) {
        super.paint(g);
        this.t.paint(g);
        this.r1.paint(g);
        this.trap.paint(g);
        }
}
