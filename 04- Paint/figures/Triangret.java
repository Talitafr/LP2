package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
public class Triangret{
	private int x;
	private int y;
	private int base;
	private int h;
	private Color fundo;
	private Color contorno;
	public Triangret(int x,int y,int base,int h,Color fundo,Color contorno){
		this.x=x;
		this.y=y;
		this.base=base;
		this.h=h;
		this.fundo=fundo;
		this.contorno=contorno;
}
	public void print () {
        System.out.format("Triângulo retângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.base, this.h, this.x, this.y);
        }
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] xdir= {(this.base) + (this.x),(this.base)/2,this.x};
		int[] ydir={this.y,(this.h) + (this.y),this.y};
		g2.drawPolygon(xdir, ydir, 3);
		g2.setColor(fundo);
		g2.fillPolygon(xdir, ydir, 3);
		g2.setColor(contorno);
		g2.drawPolygon(xdir, ydir, 3);
	}

}


