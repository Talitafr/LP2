package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Ellipse extends Figure{
   // public boolean selected;

    public Ellipse (int x, int y, int w, int h, Color fundo,Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
        this.selected = false;
    }

    public void print() {
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
    @Override
    public void foculisedobj(Graphics g){
      Graphics2D gdd = (Graphics2D) g;
        gdd.setColor(Color.black);
        gdd.drawRect((this.x),(this.y), (this.w),(this.h));
     }
 
    @Override
    public boolean setselected(boolean status){
        return this.selected = status;
    }
    
    @Override
    public void drag(int dx, int dy){
     this.x = (this.x) + dx;
     this.y = (this.y) + dy;
  } 

}
