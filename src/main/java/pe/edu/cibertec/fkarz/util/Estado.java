package pe.edu.cibertec.fkarz.util;

public enum Estado {
    GENERADO(1),
    ACTIVO(2);

    private int val;

    Estado(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }
}