#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}



///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Ellipse* ellipse_new (int x, int y, int w, int h) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) ellipse_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}


///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Triang;

void triang_print (Triang* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de tamanho (%d,%d) na posicao (%d,%d)\n",
           this->w, this->h, sup->x, sup->y);
}

Triang* triang_new (int x, int y, int w, int h) {
    Triang* this = malloc(sizeof(Triang));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) triang_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int wmenor;
} Trap;

void trap_print (Trap* this) {
    Figure* sup = (Figure*) this;
    printf("Trapézio de tamanho (%d (base maior), %d (base menor) ,%d (altura)) na posicao (%d,%d)\n",
           this->w,this->wmenor, this->h, sup->x, sup->y);
}

Trap* trap_new (int x, int y, int w, int h) {
    Trap* this = malloc(sizeof(Trap));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print)trap_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->wmenor=w/2;
    this->h = h;
}


///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) ellipse_new(40,10,140,300),
        (Figure*) triang_new(10,10,100,100),
        (Figure*) trap_new(210,110,305,130)
    };

    ///

    for (int i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (int i=0; i<4; i++) {
        free(figs[i]);
    }
}
