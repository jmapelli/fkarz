package pe.edu.cibertec.fkarz.util;

public enum Rol {
    SUSCRIPTOR(1),
    RECEPCIONISTA(2),
    CAJERO(3),
    TECNICO(4);

    private int val;

    Rol(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }
}
