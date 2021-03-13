#include <stdio.h>
struct elipse{
      int pos_x;
      int pos_y;
      int raio_x;
      int raio_y;
}elipse;
void print(struct elipse*);


int main(){
    struct elipse e1 = {5,15, 40, 50};  
    print(&e1);
    return 0;
}

void print(struct elipse* e1){
     printf("Pos (%d,%d) /  Raio (%d,%d)\n", e1->pos_x, e1->pos_y, e1->raio_x, e1->raio_y);

}

