
/**
*Tecla r - Gera um novo retângulo aleatório na posição do mouse;
*Tecla e - Gera uma nova elipse aleatória na posição do mouse;
*Tecla c - Gera um trapézio aleatório na posição do mouse;
*Tecla t - Gera um triângulo aleatório na posição do mouse;
*Tecla m - Quando a figura ta selecionada, abre a palheta de cores pra você mudar a cor de fundo;
*Tecla l (L minusculo) - Quando a figura ta selecionada, abre a palheta de cores pra você mudar a cor de contorno;
*Tecla Delete - Deleta a figura selecionada;
*Tecla + do Numpad - Aumenta a dimensão da figura selecionada;
*Tecla - do teclado principal - Diminui a dimensão da figura selecionada;
*Setas do teclado - Move a figura;
*Tecla TAB - Redireciona o foco para outra figura da lista de figuras;
*Mouse pode: Movimentar a figura pelo frame, selecionar uma figura ou,
*(se apertar em uma das teclas de Gerar figura) criar uma figura na posição do mouse.
*/
 
package lp2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import figures.*;
import static java.awt.event.KeyEvent.*;



 
class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Random rand = new Random();
    Figure foco = null;
    int hs=-1;
    int x,y = 0;
    int px=0;
    int py=0;
    Point mp=new Point(0,0);
    
    Point mouse = new Point(0,0);
    ArrayList<Rect> auxp = new ArrayList<Rect>();
    

    ListFrame () {
        
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent evt){
                px = evt.getX();
                py = evt.getY();
            }
        });
                 
     
        this.addKeyListener (
            new KeyAdapter() {
                public void keyTyped (KeyEvent evt) { 
                        
                	switch (evt.getKeyChar()) {
                            case 'e': {
                                	int x = px;
		                        int y = py;
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
					int x = px;
		                        int y = py;
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
		                        int x = px;
		                        int y = py;
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
		                        int x = px;
		                        int y = py;
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
                        for(Rect ao:auxp ){
                            if((mp.x >= ao.x) && (mp.x<=((ao.x)+(ao.w))) && ((mp.y>= ao.y) && (mp.y<=(ao.y) + (ao.h)))){  
                                hs=auxp.indexOf(ao);
                                break;
                            }
                            
                            else{
                                hs=-1;
                            }                          
                        }
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
        for (Figure fig: figs) {
            
                fig.paint(g);                                
            
        }
        if(foco!=null){
            figs.remove(foco);
            figs.add(foco);
            foco.paint(g);
            auxp=foco.making_dots();
            foco.foculisedobj(g,auxp);
 
        }

    }
}
