/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;

import figures.*;
import ivisible.Ivisivel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import static java.awt.event.KeyEvent.*;
import java.util.Random;
/**
 *
 * @author talita
 */
public class Button implements Ivisivel {
    
    JPanel b = new JPanel();
    Polygon Botao;
    int idx;//index
    private Figure fig;
    boolean clicado;
    
    ArrayList<Figure> figsb = new ArrayList<Figure>();
    Random rand = new Random();
    
    

    public Button(int idx, Figure fig) {
        this.idx = idx;
        this.fig = fig;
        
    }

    public ArrayList<Figure> add_figura_botao(ArrayList<Figure> figs){
            for(Figure figb: figsb){
                figs.add(figb);
            }
        
        return figs;
    }
        
    public void Create_figurebtn(int xf, int yf){
        
        
        switch(this.idx){
        
            case 1:{
                int xp = xf;
                int yp = yf;
                int w = rand.nextInt(50);
		int h = rand.nextInt(50);
		Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Rect r = new Rect(xp,yp, w,h,fundo,contorno);                       
		figsb.add(r);
		r.print();
                break;
            }
            case 2:{
                int xp = xf;
		int yp = yf;
		int w = rand.nextInt(50);
		int h = rand.nextInt(50);
		Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256), 255 );
		Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
		Ellipse e = new Ellipse(xp,yp, w,h,fundo,contorno);                        
		figsb.add(e);
		e.print();
                break;
            }
            case 3:{
                int xp = xf;
                int yp = yf;
                int h = rand.nextInt(50);
                int w = rand.nextInt(55) + 15;
                Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Triang t = new Triang(xp,yp, w,h,fundo,contorno);                         
                figsb.add(t);
                t.print();
                break;
            }
            case 4:{
                int xp = xf;
                int yp = yf;
                int w = rand.nextInt(100);
                int h = rand.nextInt(50);
                Color fundo = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Color contorno = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),255);
                Trapezio c = new Trapezio(xp,yp, w,h,fundo,contorno);                       
                figsb.add(c);
                c.print();
                break;
            
            
            }
        
        }
        
        
    
    }
    @Override
    public boolean clicked(int x, int y){
        clicado = Botao.contains(x, y);
        
        return clicado;
        
    }

    @Override
    public void paint(Graphics g, boolean focused) {
        Graphics2D gb = (Graphics2D) g;
        int[] xdir= {25,75,75,25};
        int[] ydir={ idx*50,idx*50,(idx +1)*50,(idx +1)*50};
        gb.setStroke(new BasicStroke(1.5f));
        Botao = new Polygon(xdir,ydir,4);
              if(focused==true){
                gb.setColor(Color.BLUE);
                gb.fillPolygon(Botao);
                gb.setColor(Color.black);
                gb.drawPolygon(Botao);
                
            
            }
              else{
                  gb.setColor(Color.LIGHT_GRAY);
                  gb.fillPolygon(Botao);
                  gb.setColor(Color.black);
                  gb.drawPolygon(Botao);
              
              }
        
          
            this.fig.paint(g, false);
            
          
        
        
        
        
        
        
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
