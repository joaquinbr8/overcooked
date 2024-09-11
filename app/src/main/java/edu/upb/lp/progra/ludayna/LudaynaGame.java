package edu.upb.lp.progra.ludayna;

import android.view.View;
import android.widget.ImageView;

import java.nio.charset.MalformedInputException;

public class LudaynaGame {
    private LudaynaConnector connector;
    private Dado dado = new Dado(this);
    //0: rojo, 1:morado, 2: amarillo, 3:verde
    private Ficha[] fichas = new Ficha[16];
    private String turno = "rojo";
    //rojo, morado, verde, amarillo
    private int[] puntos = {0,0,0,0};

    private int[][] camino = {
            {-1, -1, -1, -1, -1, -1, -1,-1,-1,-1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 0, 5, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1,  8,  8, -1, -1, -1, 1, 5, 2, -1, -1, -1,  8,  8, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 5, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1,  8,  8, -1, -1, -1, 1, 5, 2, -1, -1, -1,  8,  8, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 5, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 5, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1,  0,  0,  0,  0,  0,  0, 1, 9, 0,  0,  0,  0,  0,  0,  2, -1},
            {-1,  4,  4,  4,  4,  4,  4, 9,-1, 9,  7,  7,  7,  7,  7,  7, -1},
            {-1,  1,  3,  3,  3,  3,  3, 3, 9, 2,  3,  3,  3,  3,  3,  3, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 6, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 6, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1,  8,  8, -1, -1, -1, 1, 6, 2, -1, -1, -1,  8,  8, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 6, 2, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1,  8,  8, -1, -1, -1, 1, 6, 2, -1, -1, -1,  8,  8, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 1, 6, 3, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1,-1,-1,-1, -1, -1, -1, -1, -1, -1, -1}};


    public LudaynaGame(LudaynaConnector connector) {
        this.connector = connector;
        fichas[0] = new Ficha(2, 2, "rojo", this);
        fichas[1] = new Ficha(2, 3, "rojo", this);
        fichas[2] = new Ficha(4, 2, "rojo", this);
        fichas[3] = new Ficha(4, 3, "rojo", this);

        fichas[4] = new Ficha(2, 13, "morado", this);
        fichas[5] = new Ficha(2, 14, "morado", this);
        fichas[6] = new Ficha(4, 13, "morado", this);
        fichas[7] = new Ficha(4, 14, "morado", this);

        fichas[8] = new Ficha(12, 2, "amarillo", this);
        fichas[9] = new Ficha(12, 3, "amarillo", this);
        fichas[10] = new Ficha(14, 2, "amarillo", this);
        fichas[11] = new Ficha(14, 3, "amarillo", this);

        fichas[12] = new Ficha(12, 13, "verde", this);
        fichas[13] = new Ficha(12, 14, "verde", this);
        fichas[14] = new Ficha(14, 13, "verde", this);
        fichas[15] = new Ficha(14, 14, "verde", this);
    }

    public void clic(int vertical, int horizontal) {
        if (vertical == 8 && horizontal == 8) {
            //Ha hecho clic en el dado
            int aleatorio = dado.lanzarDado();
            connector.dado(aleatorio);
        } else if (camino[vertical][horizontal] != -1) {
            //Ha hecho clic en el camino, hay que ver si hay una ficha aqui
            for (int i = 0; i < fichas.length; i++) { //recorro las fichas
                if (fichas[i].getv() == vertical && fichas[i].geth() == horizontal) { //verifico si hice clic en una ficha
                    if (fichas[i].getColor().equals(turno)) { //la ficha donde hice clic es del jugador de turno
                        if (camino[vertical][horizontal] == 8) { //la ficha est'a en casa
                            if (dado.getUltimoResultado() == 6) { //la ficha debe salir
                                fichas[i].irAPosicionDeInicio();
                            }
                        } else {//la ficha est'a en el camino
                            int newVertical = fichas[i].getv();
                            int newHorizontal = fichas[i].geth();
                            for (int j = 0; j < dado.getUltimoResultado(); j++) {
                                switch (camino[newVertical][newHorizontal]) {
                                    case 0: // ir a la derecha
                                        newHorizontal++;
                                        break;
                                    case 1:
                                        newVertical--;
                                        break;
                                    case 2:
                                        newVertical++;
                                        break;
                                    case 3:
                                        newHorizontal--;
                                        break;
                                    case 4:
                                        if (fichas[i].getColor().equals("rojo")) { // ficha roja va a su camino de victoria
                                            newHorizontal++;
                                        } else {
                                            newVertical--;

                                        }
                                        break;
                                    case 5:
                                        if (fichas[i].getColor().equals("morado")) { // ficha morada va a su camino de victoria.
                                            newVertical++;
                                        } else {
                                            newHorizontal++;
                                        }
                                        break;
                                    case 6:
                                        if (fichas[i].getColor().equals("amarillo")) { // ficha amarilla va a su camino de victoria.
                                            newVertical--;
                                        } else {
                                            newHorizontal--;
                                        }
                                        break;
                                    case 7:
                                        if (fichas[i].getColor().equals("verde")) { // ficha verde va a su camino de victoria.
                                            newHorizontal--;
                                        } else {
                                            newVertical++;
                                        }
                                        break;
                                    default:
                                }
                            } // se bloquea el avance
                            if (camino[newVertical][newHorizontal] == 9) {
                                borrarFicha(fichas[i].getv(), fichas[i].geth());
                                fichas[i].moverFicha(-1, -1);
                                connector.llegoADestino(fichas[i].getColor());
                                switch (fichas[i].getColor()) {
                                    case "rojo":
                                        puntos[0] = Math.min(puntos[0] + 1, 4);
                                        break;
                                    case "morado":
                                        puntos[1] = Math.min(puntos[1] + 1, 4);
                                        break;
                                    case "verde":
                                        puntos[2] = Math.min(puntos[2] + 1, 4);
                                        break;
                                    case "amarillo":
                                        puntos[3] = Math.min(puntos[3] + 1, 4);
                                        break;
                                }
                                for (int punto : puntos) {
                                if(punto == 4) {
                                    connector.pantallaDeVictoria(fichas[i].getColor());
                                }
                            }

                            } else if (!hayAlguienEnEstaCasilla(newVertical, newHorizontal)) {
                                borrarFicha(fichas[i].getv(), fichas[i].geth());
                                fichas[i].moverFicha(newVertical, newHorizontal);
                                dibujarFicha(newVertical, newHorizontal, fichas[i].getColor());
                            }

                        }

                    }
                }
            }
            cambioDeTurno();
        }
    }

    private void cambioDeTurno() {
        dado.reiniciar();
        if (turno.equals("rojo")) {
            turno = "morado";
        } else if (turno.equals("morado")) {
            turno = "verde";
        } else if (turno.equals("verde")) {
            turno = "amarillo";
        } else if (turno.equals("amarillo")) {
            turno = "rojo";
        }
        connector.anunciarTurno(turno);
    }

    public void borrarFicha(int v, int h) {
        if (camino[v][h] == 8) {//casa
            connector.dibujarCasillaNegra(v, h);
        } else {
            connector.dibujarCasillaGris(v, h);
        }
    }

    public void dibujarFicha(int v, int h, String color) {
        connector.dibujarFicha(v, h, color);
    }

    public boolean hayAlguienEnEstaCasilla(int newVertical, int newHorizontal) {
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i].getv() == newVertical && fichas[i].geth() == newHorizontal) {
                return true;// hay una ficha
            }
        }
        return false; // no hay una ficha
    }

}
