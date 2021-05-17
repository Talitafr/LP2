package figures;
import ivisible.Ivisivel;
import java.awt.*;
import java.util.ArrayList;



public abstract class Figure implements Ivisivel{
        public int x;
      	public int y;
      	public int w;
      	public int h;
        public int dx;
        public int dy;
        public Color fundo;
        public Color contorno;

        
        
       
//       public abstract void paint(Graphics g);
       public abstract void print();
       public abstract void settSize(int dx, int dy,int hs);



    public void drag(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }
    
    public ArrayList<Rect> making_dots(){
        ArrayList<Rect> dots = new ArrayList<Rect>();
        int dot = 7;
        Rect O,NO,SO,N,S,NL,L,SL;
        NO = new Rect(this.x - dot,this.y - dot,dot,dot,Color.cyan,Color.black);
        dots.add(NO);
        N = new Rect((this.x)+(this.w)/2 - dot/2 , this.y - dot , dot, dot,Color.cyan,Color.black);
        dots.add(N);
        NL = new Rect((this.x)+(this.w)  , this.y - dot , dot, dot,Color.cyan,Color.black);
        dots.add(NL);
        O = new Rect(this.x - dot, (this.y)+((this.h))/2 - dot/2, dot, dot,Color.cyan,Color.black );
        dots.add(O);
        L = new Rect((this.x)+(this.w), (this.y)+(this.h)/2 - dot/2 , dot, dot, Color.cyan,Color.black );
        dots.add(L);
        SO = new Rect(this.x - dot, (this.y)+(this.h), dot, dot, Color.cyan,Color.black);
        dots.add(SO);
        S = new Rect((this.x)+(this.w)/2 - dot/2, (this.y)+(this.h) , dot, dot, Color.cyan,Color.black);
        dots.add(S);
        SL = new Rect((this.x)+(this.w), (this.y)+(this.h) , dot, dot, Color.cyan,Color.black);
        dots.add(SL);
        return dots;
        
    }
    

    public void foculisedobj(Graphics g,ArrayList<Rect> dots){
        Graphics2D gdd = (Graphics2D) g;
        gdd.setStroke(new BasicStroke(1.5f));
        gdd.setColor(Color.black);
        gdd.drawRect((this.x),(this.y), (this.w),(this.h));
        for( Rect ponto: dots){
            gdd.setColor(ponto.contorno);
            gdd.drawRect(ponto.x, ponto.y, ponto.w, ponto.h);
            gdd.setColor(ponto.fundo);
            gdd.fillRect(ponto.x, ponto.y, ponto.w, ponto.h);
         }
    }
}
