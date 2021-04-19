package figures;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

public class Triang extends Figure{

	
 public Triang(int x,int y,int w,int h,Color fundo,Color contorno){
 		this.x=x;
 		this.y=y;
	 	this.w=w;
	 	this.h=h;
	 	this.fundo=fundo;
	 	this.contorno=contorno;
                this.selected = false;
   
}
	public void print() {
        System.out.format("Triângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
        }
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] xdir= {this.x,((this.w)/2) + (this.x),(this.w) + (this.x)};
		int[] ydir={this.y, (this.y) - (this.h),this.y};
		g2.drawPolygon(xdir, ydir, 3); 
		g2.setColor(fundo);
		g2.fillPolygon(xdir, ydir, 3);
		g2.setColor(contorno);
		g2.drawPolygon(xdir, ydir, 3);
	}
  public void foculisedobj(Graphics g){
     Graphics2D gdd = (Graphics2D) g;
        gdd.setColor(Color.black);
        gdd.drawRect( this.x , (this.y) - (this.h) , (this.w),(this.h));
    }

    @Override
    public boolean setselected(boolean status) {
        return this.selected = status;
    }

    @Override
    public void drag(int dx, int dy) {
        this.x = (this.x) + dx;
        this.y = (this.y) + dy;
    }


}


