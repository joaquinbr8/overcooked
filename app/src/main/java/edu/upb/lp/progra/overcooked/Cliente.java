package edu.upb.lp.progra.overcooked;

public abstract class Cliente {
    protected String nombre;
    protected int penalidad;


    public Cliente(String nombre,int penalidad){
        this.nombre = nombre;
        this.penalidad = penalidad;
    }

    public abstract void reaccionALaFalla();
}
