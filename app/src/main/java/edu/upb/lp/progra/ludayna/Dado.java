package edu.upb.lp.progra.ludayna;

import java.util.Random;

public class Dado {
    private LudaynaGame game;
    private int ultimoResultado = -1;
    private Random random = new Random();

    public Dado(LudaynaGame game) {this.game = game;}

    public int lanzarDado() {
        if (ultimoResultado == -1) {
            int numero = random.nextInt(6) + 1;
            ultimoResultado = numero;
        }
        return ultimoResultado;
    }

    public int getUltimoResultado() {
        return ultimoResultado;
    }

    public void reiniciar() {
        ultimoResultado = -1;
    }
}

