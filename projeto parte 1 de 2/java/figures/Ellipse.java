package figures;
import java.awt.*;


public class Ellipse extends Figure{
   

    public Ellipse (int x, int y, int w, int h, Color fundo,Color contorno) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.fundo = fundo;
        this.contorno = contorno;

    }

    @Override
    public void print() {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    @Override
    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.fundo);
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.setColor(this.contorno);
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }   
    
    @Override
     public void settSize(int dx, int dy, int hs) {
switch(hs){
            
            case 0: {//Quadrado NW
                this.x =this.x + dx;
                this.y= this.y + dy;
                this.w = this.w - dx;
                this.h = this.h - dy;
                break;
            }
            case 1:{//Quadrado N
                
                this.y=  this.y + dy;
                this.h =  this.h - dy;
                break;
            
            }
            case 2:{//Quadrado NE
                
                this.y= this.y + dy;
                this.w = this.w + dx;
                this.h = this.h - dy;
                break;
            }
            
            case 3:{//Quadrado W
                this.x =this.x + dx;
                this.w = this.w - dx;
                break;
            }
            case 4:{//Quadrado E
                this.w = this.w + dx;
                break;
            }
            case 5:{//Quadrado SW
                    this.x =this.x + dx;
                    this.w = this.w - dx;
                    this.h = this.h + dy;
                    break;
            
            }
            case 6:{//Quadrado S
                this.h = this.h + dy;
                break;
            
            }
            case 7:{//Quadrado SE
                this.w = this.w + dx;
                this.h = this.h + dy;
                break;
            }
            case 8:{// + ou - do teclado
                this.w = this.w + dx;
                this.h = this.h + dy;
                break;
            }
            
            
        }
        //Configurando tamanho minimo
        if((this.w<=0)&&(this.h<=0)){
            this.w=5;
            this.h=5;
        }
        else if(this.h<=0){
            this.h=5;
        }
        else{
            if(this.w<=0){
                this.w=5;
            }
        }
    }
    

}
