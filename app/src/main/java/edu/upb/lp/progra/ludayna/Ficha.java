package edu.upb.lp.progra.ludayna;

public class Ficha {
    private int v,h;
    private String color;
    private LudaynaGame game;


    public Ficha(int v,int h, String color, LudaynaGame game) {
        this.v=v;
        this.h=h;
        this.color=color;
        this.game = game;

    }
    public int geth(){
        return h;
    }
    public int getv(){
        return v;
    }


    public void irAPosicionDeInicio() {
        int newVertical = 0;
        int newHorizontal = 0;
        //Cambiar las coordenadas
        if (color.equals("rojo")) {
            newVertical = 7;
            newHorizontal = 2;
        } else if (color.equals("morado")) {
            newVertical = 2;
            newHorizontal = 9;
        }
        else if (color.equals("verde")) {
            newVertical = 9;
            newHorizontal = 14;
        }
        else if (color.equals("amarillo")){
            newVertical = 14;
            newHorizontal = 7;
        }
        if (!game.hayAlguienEnEstaCasilla(newVertical, newHorizontal)) {
            //borra su imagen
            game.borrarFicha(v,h);
            v = newVertical;
            h = newHorizontal;
            //Redibujar la ficha
            game.dibujarFicha(v,h,color);
        }


    }

    public String getColor() {
        return color;
    }
    public void moverFicha (int newVertical, int newHorizontal){
        v = newVertical;
        h = newHorizontal;
    }
}
