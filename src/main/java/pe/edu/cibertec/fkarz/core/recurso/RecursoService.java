package pe.edu.cibertec.fkarz.core.recurso;

public class RecursoService {

    private RecursoRepository rr;

    //Categorias
    public static final String CATEGORIA_ESTADO = "estado";
    public static final String CATEGORIA_TIPO = "tipo";

    //Estado
    public static final String ESTADO_GENERADO = "generado";
    public static final String ESTADO_ACTIVADO = "activado";
    public static final String ESTADO_CONTRATADO = "contratado";

    public RecursoEntity buscar(String valor, String categoria) {
        rr = new RecursoRepository();
        return rr.find(valor, categoria);
    }
}
