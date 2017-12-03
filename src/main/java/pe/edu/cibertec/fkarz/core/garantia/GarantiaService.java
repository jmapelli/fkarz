package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.core.recurso.RecursoEntity;
import pe.edu.cibertec.fkarz.core.recurso.RecursoService;
import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;

public class GarantiaService {

    private GarantiaRepository repository = null;
    private RecursoService recursoService = null;


    public static final double MONTO = 5000.0;

    public GarantiaEntity guardar(ReservaEntity reserva) throws Exception {
        repository = new GarantiaRepository();

        GarantiaEntity garantia = new GarantiaEntity();
        garantia.setMonto(GarantiaService.MONTO);
        garantia.setReserva(reserva);
        garantia = repository.guardar(garantia);

        this.guardarEstado(RecursoService.ESTADO_GENERADO, garantia);

        return garantia;
    }

    public void guardarEstado(String nombre, GarantiaEntity garantia) throws Exception {
        recursoService = new RecursoService();
        repository = new GarantiaRepository();

        RecursoEntity estado = recursoService.buscar(nombre, RecursoService.CATEGORIA_ESTADO);

        GarantiaEstadoEntity gee = new GarantiaEstadoEntity();
        gee.setGarantia(garantia);
        gee.setEstado(estado);
        repository.guardarEstado(gee);
    }

}
