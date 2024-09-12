package edu.upb.lp.progra.overcooked;

public class ClienteEnojado extends Cliente {
    public ClienteEnojado(String nombre, int penalidad) {
        super(nombre, 0);
    }

    @Override
    public void reaccionALaFalla() {
        System.out.println("El cliente esta gritando");
    }
}
