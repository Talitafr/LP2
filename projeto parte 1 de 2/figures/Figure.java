package figures;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;

import javax.swing.*;


public abstract class Figure{
        public int x;
      	public int y;
      	public int w;
      	public int h;
        public int dx;
        public int dy;
       protected Color fundo;
        protected Color contorno;
        //public boolean selected;
    public boolean selected;
        
       
       public abstract void paint(Graphics g);
       public abstract void print();

      public abstract void foculisedobj(Graphics g);
      public abstract boolean setselected(boolean status);
     // public void setselected(){
       // this.selected = true;
  //}
      public abstract void drag(int dx, int dy);
       
}
