#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

typedef struct Rect{
  int x,y;
  int w,h;
}Rect;

Rect* rect_new (void){
    Rect* this  = malloc(sizeof(Rect));
    this->x = 0;
    this->y = 0;
    this->w = 10;
    this->h = 20;
    return this;
}

void rect_drag (Rect* this, int dx, int dy){
    this->x = this->x + dx;
    this->y = this->y + dy; 
}

void rect_print (Rect* this){
    printf("Retângulo de tamanho (%d,%d ) na posicao (%d,%d)\n", this->w, this->h, this->x, this->y);
}
