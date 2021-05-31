

 
package lp2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import static java.awt.event.KeyEvent.*;
import java.io.*;



 
class ListFrame extends JFrame {
    
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Button focus_but = null;
    Random rand = new Random();
    Figure foco = null;
    int hs=-1;
    int x,y = 0;
    Point p = new Point(0,0);
    public Point mp=new Point(0,0);
    Button botao;
    Point mouse = new Point(0,0);
 
    

    ListFrame () {
        try{
           FileInputStream f = new FileInputStream("proj.bin");
           ObjectInputStream o = new ObjectInputStream(f);
           this.figs = (ArrayList<Figure>) o.readObject();
           o.close();
        
        }
        catch(Exception x){
            System.out.println("ERRO!");
        }
        
        Button botaoret = new Button(1,new Rect(40,60,25,25, Color.black,Color.black));
        buts.add(botaoret);
        Button botaoel = new Button(2,new Ellipse(40,110,25,25, Color.black,Color.black));
        buts.add(botaoel);
        Button botaotri = new Button(3,new Triang(40,160,25,25, Color.black,Color.black));
        buts.add(botaotri);
        Button botaotra = new Button(4,new Trapezio(40,220,25,25, Color.black,Color.black));
        buts.add(botaotra);
        
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    try{
                        FileOutputStream f = new FileOutputStream("proj.bin");
                        ObjectOutputStream o = new ObjectOutputStream(f);
                        o.writeObject(figs);
                        o.flush();
                        o.close();
                    }
                    catch(Exception x){
                    }
                    
                    System.exit(0);
                }
            }
        );
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent evt){
               p=evt.getPoint();
               
            }
        });
                 
     
        this.addKeyListener (
            new KeyAdapter() {
                public void keyTyped (KeyEvent evt) { 
                        
                	switch (evt.getKeyChar()) {
                            case 'e': {
                                	int x = p.x;
		                        int y = p.y;
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256), 255 );
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Ellipse e = new Ellipse(x,y, w,h,fundo,contorno);                        
		                        figs.add(e);
		                        e.print();
		                        repaint();  // outer.repaint()
		                        break;
                                        }
                            
                            case 'r':{
					int x = p.x;
		                        int y = p.y;
		                        int w = rand.nextInt(50);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Rect r = new Rect(x,y, w,h,fundo,contorno);                       
		                        figs.add(r);
		                        r.print();
		                        repaint();  // outer.repaint()                                        
		                        break;
                                    }
                            
		            case 't':{
		                        int x = p.x;
		                        int y = p.y;
		                        int h = rand.nextInt(50);
		                        int w = rand.nextInt(55) + 15;
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Triang t = new Triang(x,y, w,h,fundo,contorno);                         
		                        figs.add(t);
		                        t.print();
		                        repaint();  // outer.repaint()
		                        break;
		                        }
                                  
		            case 'c' :{
		                        int x = p.x;
		                        int y = p.y;
		                        int w = rand.nextInt(100);
		                        int h = rand.nextInt(50);
		                        Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		                        Trapezio c = new Trapezio(x,y, w,h,fundo,contorno);                       
		                        figs.add(c);
		                        c.print();
		                        repaint(); // outer.repaint()
                                        break;     
                                    
		                 }
                                 
                            case 'm':{
                                     
                                        if(foco!=null){
                                             JColorChooser colorChooser = new JColorChooser();
                                            foco.fundo = JColorChooser.showDialog(null, "Escolha uma cor para o fundo da figura", Color.black);
                                            repaint();
                                        }
                                        break;
                                 }

                            case 'l':{
                                     
                                        if(foco!=null){
                                             JColorChooser colorChooser = new JColorChooser();
                                            foco.contorno = JColorChooser.showDialog(null, "Escolha uma cor para o contorno da figura ", Color.black);
                                            repaint();
                                        }

                                        break;
                                }
                                 
                            case VK_DELETE :{
                                         if(foco!=null){
                                            figs.remove(foco);
                                            foco=null;
                                            repaint();
                                        }
                                                                          
                                        break;
                                 }                                 
			}
                }    
                public void keyPressed (KeyEvent evt){
                    switch(evt.getKeyCode()){                        
                      
                        case 37:{//LEFT
                            
                            if(foco!=null){
                                foco.drag( -10,0);
                                repaint();                                                                                  
                                }
                                          
                            break;
                        }
                    
                        case 38 :{//UP
                            
                            if(foco!=null){
                                foco.drag(0,-10);
                                repaint();                                                                                                                   
                            }
                                         
                            break;                       
                        }
                        case 39:{ //RIGHT
                            
                            if(foco!=null){
                                foco.drag(10,0);                                            
                                repaint();
                            }
                                        
                            break;
                        }
                        
                        case 40:{//DOWN
                            
                                if(foco!=null){
                                   foco.drag(0,+10);
                                   repaint();
                                 }
                                   
                            break;                            
                        }
                        
                        case KeyEvent.VK_TAB:{
                                                                 
                               if(foco!=null){ 
                                    foco=figs.get(0);
                                    repaint();
                                }
                                                        
                            break;                      
                        }    
                        
                        case (KeyEvent.VK_ADD):{
                                                           
                               if(foco!=null){ 
                                   foco.settSize( + 10,  + 10,8);
                                   repaint();
                               }
                            
                            break;
                            }    
                        
                        case (KeyEvent.VK_SUBTRACT):{
                                            
                               if(foco!=null){ 
                                   foco.settSize(- 10,  - 10,8);
                                   repaint();
                               }
                            
                            break;
                            
                         }
                
                    }
                }
            }
      );
        
        this.addMouseListener(new MouseAdapter() {
             public void mouseClicked (MouseEvent evt){
               	x= evt.getX();
                y= evt.getY();
                for(Button but:buts){
                    if(but.clicked(x, y)){
                        focus_but= but;
                        repaint();
                        break;
                    }
                    else{
                        
                        focus_but=null;                       
                        repaint();
                    }
                    
                }
            	for(int i = figs.size()-1;i>=0;i--) {
                    if(figs.get(i).clicked(x, y)){ 
                        foco = figs.get(i);
                        repaint();
                        break;
                        }
                    
                    
                    else{
                        foco=null;
                        repaint();
                    }
            	 }
             }
             
             public void mousePressed(MouseEvent evt){
                               
                 if(foco!=null){
                        mp= evt.getPoint();
                        hs=foco.handlerizar(mp);
                        
                        if((!((mp.x >= foco.x) && (mp.x<=((foco.x)+(foco.w))) && ((mp.y>= foco.y) && (mp.y<=(foco.y) + (foco.h)))))&&(hs==-1)){
                                foco=null;
                                repaint();
                        }
                }
             }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
              public void mouseDragged( MouseEvent evt){
                 
                  mouse = evt.getPoint();
                  
                        if(foco!=null){

                                if(hs!=-1){
                                    
                                    foco.settSize(mouse.x - mp.x, mouse.y - mp.y,hs);
                                    mp=mouse;
                                    repaint();  
                                }
                                else{
                                    
                                    foco.drag(mouse.x - mp.x , mouse.y - mp.y);
                                    mp=mouse;
                                    repaint();
                                    
                                }
                        
                    }
                        
                  
                  }
              });


        this.setTitle("Projeto");
        this.setSize(350, 350);        
   }

     public void paint (Graphics g) {
        
        super.paint(g);
        for(Button but : buts){
            
                but.paint(g,false);
            
        }
        if(focus_but!=null){
            focus_but.paint(g, true);
            focus_but.Create_figurebtn(x, y);
            figs=focus_but.add_figura_botao(figs);
        }
        
        for (Figure fig: figs) {
            
                fig.paint(g,false);                                
            
        }
        if(foco!=null){
            figs.remove(foco);
            figs.add(foco);
            foco.paint(g,true);
 
        }

    }
}
