import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
       this.getContentPane().setBackground(Color.blue);
        Graphics2D g2d = (Graphics2D) g;        
        g2d.setPaint(Color.pink);
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
        Graphics2D retan1 = (Graphics2D) g;
        retan1.drawRect(0,0, w/3, h);
        retan1.setPaint(Color.blue);
        retan1.fillRect(0, 0, w/3, h);
        Graphics2D retan2 = (Graphics2D) g;
        retan2.drawRect(w/3, 0, w/3, h);
        retan2.setPaint(Color.white);
        retan2.fillRect(w/3, 0, w/3, h);
        Graphics2D retan3 = (Graphics2D) g;
        retan3.drawRect(w*2/3, 0, w/3, h);
        retan3.setPaint(Color.red);
        retan3.fillRect(w*2/3, 0, w/3, h);       
    }
}
