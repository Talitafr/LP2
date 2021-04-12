package figures;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Figure{
       public int x;
      	public int y;
      	public int w;
      	public int h;
       //protected int dx;
       //protected int dy;
       protected Color fundo;
	      protected Color contorno;
       
       public abstract void paint(Graphics g);
       public abstract void print();

       public abstract void foculisedobj(Graphics g);
      

