import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import figures.*;
class RectEllipseFigApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    Ellipse e2;
    Ellipse e3;
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
        this.r1 = new Rect(50,50, 100,30,Color.pink,Color.blue);
        this.e1 = new Ellipse(50,100, 100,30,Color.yellow,Color.red);
        this.e2 = new Ellipse(50,150, 100,30,Color.cyan,Color.black);
        this.e3 = new Ellipse(50,200, 100,30,Color.green,Color.blue);
        this.t = new Triangret(50,250, 100,30,Color.yellow,Color.blue);
        this.trap = new Trapezio(50,295, 100,60,45,Color.orange,Color.red);
        }

    public void paint (Graphics g) {
        super.paint(g);
        this.t.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
        this.trap.paint(g);
        }
}

