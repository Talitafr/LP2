package figures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;




public abstract class Figure{
        public int x;
      	public int y;
      	public int w;
      	public int h;
        public int dx;
        public int dy;
        public Color fundo;
        public Color contorno;
        public boolean selected;
        public boolean deleter = false;
        
       
       public abstract void paint(Graphics g);
       public abstract void print();
       public abstract void settSize(int dx, int dy);

    public void setselected(boolean status) {
         this.selected = status;
    }

    public void drag(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public void foculisedobj(Graphics g){
         Graphics2D gdd = (Graphics2D) g;
        gdd.setColor(Color.red);
        gdd.drawRect((this.x),(this.y), (this.w),(this.h));
         }
}
