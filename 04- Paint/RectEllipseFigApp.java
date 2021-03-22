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
        this.trap = new Trapezio(50,295, 100,30,45,Color.orange,Color.red);
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

class Rect {
    private int x, y;
    private int w, h;
    private Color fundo;
    private Color contorno;

    Rect (int x, int y, int w, int h,Color fundo,Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }

    public void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(this.fundo);
        g.fillRect(this.x,this.y, this.w,this.h);
          
        g.setColor(this.contorno);
        g.drawRect(this.x, this.y, this.w, this.h);
        
    }
}


class Ellipse {
    private int x, y;
    private int w, h;
    private Color fundo;
    private Color contorno;

    Ellipse (int x, int y, int w, int h, Color fundo,Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
    }

    public void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.fundo);
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.contorno);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }   
}



