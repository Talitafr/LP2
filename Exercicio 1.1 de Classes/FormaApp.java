
class FormaApp{
	public static void main(String [] args) {
		Poligono p= new Poligono(15,15,5,20,20);
			p.print();
		}
}
class Poligono{
		int x;
		int y;
		int nl;//numero de lados
		int w; //comprimento
		int h; //largura
		
		Poligono(int pos_x, int pos_y, int nlados, int comp, int larg){
			
		this.x = pos_x;
		this.y = pos_y;
		this.nl = nlados;
		this.w = comp;
		this.h = larg;
		}
		void print() {
			System.out.format(" Posição (x,y): (%d,%d)\n Número de lados: %d\n Comprimento: %d\n Largura: %d\n ",
			this.x, this.y, this.nl, this.w, this.h);
		}
}
	
	
		
	