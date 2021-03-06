import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2,r3;

    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 150,30,Color.cyan,Color.black);
        this.r2 = new Rect(100,175,200,100,Color.yellow,Color.red);
        this.r3 = new Rect(350,50,200,150,Color.cyan,Color.pink);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    Color fundo;
    Color contorno;
 

    Rect (int x, int y, int w, int h,Color fundo, Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo=fundo;
        this.contorno=contorno;
        
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //this.fundo=fundo;
        g2d.drawRect(this.x,this.y, this.w,this.h);
        g2d.setColor(this.fundo);
        g2d.fillRect(this.x,this.y, this.w,this.h);
          
        //this.contorno=contorno;
        g2d.setColor(this.contorno);
        g2d.drawRect(this.x, this.y, this.w, this.h);
        
    }
    
}

