package figures;
import java.awt.*;

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
        @Override
	public void print() {
        System.out.format("Triângulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
        }
	
        @Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		int[] xdir= {((this.w)/2) + (this.x),this.x,(this.w) + (this.x)};
		int[] ydir={ (this.y),(this.y)+(this.h),(this.y)+(this.h)};
		g2.drawPolygon(xdir, ydir, 3); 
		g2.setColor(fundo);
		g2.fillPolygon(xdir, ydir, 3);
		g2.setColor(contorno);
		g2.drawPolygon(xdir, ydir, 3);
	}

        @Override
        public void setSize(int dx, int dy) {
        this.w = dx;
        this.h = dy;
    }
        
}


