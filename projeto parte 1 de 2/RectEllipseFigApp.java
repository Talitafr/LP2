/*
Tecla r - Gera um novo retângulo aleatório;
Tecla e - Gera uma nova elipse aleatória;
Tecla c - Gera um trapézio aleatório;
Tecla t - Gera um triângulo aleatório.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.util.ArrayList;
import java.util.Random;
import figures.*;


class RectEllipseFigApp {
    public static void main (String[] args) {
        ListFrame frame1 = new ListFrame();
        frame1.setVisible(true);
        //JLayeredPane layeredPane = new JLayeredPane();
        //layeredPane.setBounds(0,0,350,350);
        //frame1.add(layeredPane);
        
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure foco = null;
    
    public boolean selected;
    Point antes;
    
    
   
    
    
    ListFrame () {
        
        //Figure foco;
        
        
       // this.focus = null;
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
                    
                	switch (evt.getKeyChar()) {
                            case 'e': {
                                	int x = rand.nextInt(350);
		                        int y = rand.nextInt(350);
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Ellipse e = new Ellipse(x,y, w,h,fundo,contorno);                        
		                        figs.add(e);
		                        e.print();
		                        repaint();  // outer.repaint()
                                        //layeredPane.add(e);
		                        break;
                                        }
                            case 'r':{
					int x = rand.nextInt(350);
		                        int y = rand.nextInt(350);
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Rect r = new Rect(x,y, w,h,fundo,contorno);                       
		                        figs.add(r);
		                        r.print();
		                        repaint();  // outer.repaint()
                                        //layeredPane.add(r);
		                        break;
                                    }
		                  case 't':{
		                        int x = rand.nextInt(350);
		                        int y = rand.nextInt(350);
		                        int h = rand.nextInt(50);
		                        int w = rand.nextInt(55) + 15;
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Triang t = new Triang(x,y, w,h,fundo,contorno);                         
		                        figs.add(t);
		                        t.print();
		                        repaint();  // outer.repaint()
		                        break;
		                        }
		                 case 'c' :{
		                        int x = rand.nextInt(350);
		                        int y = rand.nextInt(350);
		                        int w = rand.nextInt(100); 
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
		                        Trapezio c = new Trapezio(x,y, w ,h,fundo,contorno);                       
		                        figs.add(c);
		                        c.print();
		                        repaint(); // outer.repaint()
                                        break;     
                                    
		                 }
				}
           }
         }
      );
        this.addMouseListener(new MouseAdapter() {
             public void mousePressed (MouseEvent evt){
            	
            	 int x,y = 0;
            	 x= evt.getX();
              y= evt.getY();
            	for(Figure fig: figs) {
                    if((x >= fig.x) && (x<=((fig.x)+(fig.w))) && ((y>= fig.y) && (y<=(fig.y) + (fig.w)))){ 
                        foco = fig;
                        Figure temp;
                        int c = figs.indexOf(fig);
                        int z = ((int)figs.size()-1);
                        temp = figs.get(z);
                        figs.set(z, figs.get(c));
                        figs.set(c, temp);
                
                
                       
                       foco.setselected(true);
                       repaint();
                       
                        
                        System.out.println(fig.selected);
                        
                        
                       
                        }
                    else{
                        fig.setselected(false);
                    }
            	 }
                
            			  
            	
             }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
              public void mouseDragged( MouseEvent evt){
                  
                  
                  
                  for(Figure fig: figs) {
                        if(fig.selected==true){
                            
                            Point p = MouseInfo.getPointerInfo().getLocation();
                            int x = p.x - getLocation().x;
                            int y = p.y - getLocation().y;
                            System.out.format("%d x\n %d y\n ", fig.x,fig.y);
                            fig.drag(x, y);
                            System.out.format("%d x\n %d y\n ", fig.x,fig.y);
                            break;
                            
                        }
                        
                        else{
                                fig.setselected(false);
                                
                            } 
                        
                        
                  }
                  repaint();
                  }
              });


        this.setTitle("Lista de Elipses");
        this.setSize(350, 350);
        
       
        
   }
   


    public void paint (Graphics g) {
        
        
        
       
        super.paint(g);
        for (Figure fig: figs) {
            if(fig.selected == true){
               
              
               int c = figs.indexOf(fig);
               figs.get(c).paint(g);
               figs.get(c).foculisedobj(g);
               
               
                

                
            }
            else{
                fig.paint(g);
                
            }
        }
            
           
        
        
    }
}

