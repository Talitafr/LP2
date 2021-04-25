package figures;
import java.awt.*;

public class Rect extends Figure{
    

    public Rect (int x, int y, int w, int h,Color fundo,Color contorno) {
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
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g) {
        g.drawRect(this.x,this.y, this.w,this.h);
        g.setColor(this.fundo);
        g.fillRect(this.x,this.y, this.w,this.h);
          
        g.setColor(this.contorno);
        g.drawRect(this.x, this.y, this.w, this.h);
        
    }
    
    @Override
    public void setSize(int dx, int dy) {
        this.w = dx;
        this.h = dy;
    }
    
    
     
}

