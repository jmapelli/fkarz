package pe.edu.cibertec.fkarz.util;

public enum Estado {
    GENERADO(1),
    ACTIVO(2),
    CONTRATADO(4),
    RETENIDO(3);

    private int val;

    Estado(int val) {
        this.val = val;
    }

    public int val() {
        return val;
    }


    public static String toString(int val) {
        String text = "";

        switch (val) {
            case 1:
                text = "GENERADO";
                break;
            case 2:
                text = "ACTIVO";
                break;
            case 3:
                text = "RETENIDO";
                break;
            case 4:
                text = "CONTRATADO";
                break;
        }

        return text;
    }
}