package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Trapezio extends Figure{
	 protected int basemenor;

 	public Trapezio(int x,int y,int w,int h,Color fundo,Color contorno){
  		this.x=x;
  		this.y=y;
  		this.w=w;
  		this.h=h;
  		this.fundo=fundo;
  		this.contorno=contorno;
    basemenor = ((this.w)/2);
}
	public void print() {
        System.out.format("Trapézio de tamanho (%d, base maior; %d, base menor;%d, altura) na posicao (%d,%d)\n",
            this.w,basemenor, this.h, this.x, this.y);
        }
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] xdir= {this.x,this.x,(this.w)+(this.x), (this.basemenor)+ (this.x)};
		int[] ydir={this.y,(this.h) + (this.y),(this.h) + (this.y),this.y};
		g2.drawPolygon(xdir, ydir, 4);
		g2.setColor(this.fundo);
		g2.fillPolygon(xdir, ydir, 4);
		g2.setColor(this.contorno);
		g2.drawPolygon(xdir, ydir, 4);
	}

}
