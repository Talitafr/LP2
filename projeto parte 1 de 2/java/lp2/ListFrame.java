
/**
*Tecla r - Gera um novo retângulo aleatório;
*Tecla e - Gera uma nova elipse aleatória;
*Tecla c - Gera um trapézio aleatório;
*Tecla t - Gera um triângulo aleatório.
*Tecla m - Quando a figura ta selecionada, abre a palheta de cores pra você mudar a cor
*Tecla Delete - Deleta a figura selecionada
*Tecla + do Numpad - Aumenta a dimensão da figura selecionada
*Tecla - do teclado principal - Diminui a dimensão da figura selecionada
*Setas do teclado - Move a figura
*Tecla TAB - Redireciona o foco para outra figura da lista de figuras (aleatória)
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
    int x,y = 0;
    public boolean selected;
    int px;
    int py;
    
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
                                     for(Figure fig: figs) {
                                         if(fig.selected==true){
                                             JColorChooser colorChooser = new JColorChooser();
                                            fig.fundo = JColorChooser.showDialog(null, "escolha uma cor ", Color.blue);
                                            repaint();
                                         }
                                     
                                     }
                                 
                                 break;
                                 }

                                    case 'l':{// L minusculo
                                     for(Figure fig: figs) {
                                         if(fig.selected==true){
                                             JColorChooser colorChooser = new JColorChooser();
                                            fig.contorno = JColorChooser.showDialog(null, "escolha uma cor ", Color.blue);
                                            repaint();
                                         }
                                     
                                     }
                                 
                                 break;
                                 }
                                 
                                 case VK_DELETE :{
                                     for(Figure fig: figs) {
                                         if(fig.selected==true){
                                            fig.deleter= true;
                                         repaint();
                                         }
                                     
                                     }
                                     break;
                                 }                                 
				}
                }    
                public void keyPressed (KeyEvent evt){
                    switch(evt.getKeyCode()){                        
                      
                        case 37:{//LEFT
                                for(Figure fig: figs) {
                                         if(fig.selected==true){
                                         fig.drag( -10,0);
                                         repaint();                                                                                  
                                         }
                                     }     
                                     break;
                        }
                    
                        case 38 :{//UP
                            for(Figure fig: figs) {
                                         if(fig.selected==true){
                                            fig.drag(0,-10);
                                            repaint();                                                                                                                   
                                         }
                                     }    
                                    break;                       
                        }
                        case 39:{ //RIGHT
                            for(Figure fig: figs) {
                                         if(fig.selected==true){
                                            fig.drag(10,0);                                            
                                            repaint();
                                         }
                                    }    
                                    break;
                        }
                        case 40:{//DOWN
                            for(Figure fig: figs) {
                                if(fig.selected==true){
                                   fig.drag(0,+10);
                                   repaint();
                                 }
                               }    
                            break;                            
                        }
                        case KeyEvent.VK_TAB:{
                            for(Figure fig: figs) {                               
                               if(fig.selected==true){ 
                                fig.setselected(false);
                                if(figs.size()>=2){
                                    figs.get(rand.nextInt(figs.size()-1)).setselected(true);
                                    
                                    }
                                }
                               repaint();
                            }
                            break;                      
                        }                       
                        case (KeyEvent.VK_ADD):{
                            for(Figure fig: figs) {                               
                               if(fig.selected==true){ 
                                   fig.setSize(fig.w + 10, fig.h + 10);
                                   repaint();
                               }
                            }
                            break;
                            }                        
                        case (KeyEvent.VK_MINUS):{
                            for(Figure fig: figs) {                               
                               if(fig.selected==true){ 
                                   fig.setSize(fig.w - 10, fig.h - 10);
                                   repaint();
                               }
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

                        }
                    else{
                        
                        
                        
                        fig.setselected(false);
                       
                        repaint();
                    }
                    repaint();
            	 }
             }
        });

        this.addMouseMotionListener(new MouseMotionAdapter(){
              public void mouseDragged( MouseEvent evt){
                  int xmd = evt.getX();
                  int ymd = evt.getY();
                
                  for(Figure fig: figs) {
                        if(fig.selected==true){
                            fig.drag(xmd - fig.x , ymd - fig.y);
                            repaint();    
                        }
                        
                        else{
                            
                                fig.setselected(false); 
                            }      
                  }
                  
                  }
              });
        this.addMouseListener(new MouseAdapter() {
            public void mouseReleased (MouseEvent evt){
                
                
                  for(Figure fig: figs) {
                        
                            fig.setselected(false);              
                        }
            }
        });

        this.setTitle("Lista de Elipses");
        this.setSize(350, 350);        
   }

     public void paint (Graphics g) {
        
        Figure deletado = null;
        int c = -1;
        super.paint(g);
        for (Figure fig: figs) {
            if(fig.selected == true){
              if(fig.deleter==true){
                   fig.deleter = false;
                   deletado= fig;
                   
                } 
              else{
             
               c = figs.indexOf(fig);
              }               
            }
            else{
                fig.paint(g);                                
            }
        }
            
         figs.remove(deletado);
         
         if(c>=0){
             int z = ((int)figs.size()-1);
             Figure temp;
             temp = figs.get(z);
             figs.set(z, figs.get(c));
             figs.set(c, temp);           
             figs.get(z).paint(g);
             figs.get(z).foculisedobj(g);
         }  
    }
}
