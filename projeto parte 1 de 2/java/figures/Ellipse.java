package figures;
import java.awt.*;


public class Ellipse extends Figure{
   

    public Ellipse (int x, int y, int w, int h, Color fundo,Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;
        this.selected = false;
    }

    @Override
    public void print() {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.fundo);
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.contorno);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }   
    
    @Override
     public void settSize(int dx, int dy) {
        this.w = dx;
        this.h = dy;
    }
    

}
