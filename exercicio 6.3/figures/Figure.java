package figures;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure{
       protected int x;
      	protected int y;
      	protected int w;
      	protected int h;
       protected Color fundo;
	      protected Color contorno;
       
       public abstract void paint(Graphics g);
       public abstract void print();
}
