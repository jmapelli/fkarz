package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.util.Estado;

public class GarantiaService {

    private GarantiaRepository repository = null;

    public static final double MONTO = 5000.0;

    public GarantiaEntity guardar(ReservaEntity reserva) throws Exception {
        repository = new GarantiaRepository();

        GarantiaEntity garantia = new GarantiaEntity();
        garantia.setMonto(GarantiaService.MONTO);
        garantia.setReserva(reserva);
        garantia = repository.guardar(garantia);

        this.guardarEstado(Estado.RETENIDO.val(), garantia);

        return garantia;
    }

    public void guardarEstado(int estado, GarantiaEntity garantia) throws Exception {
        GarantiaEstadoEntity gee = new GarantiaEstadoEntity();
        gee.setGarantia(garantia);
        gee.setEstado(estado);
        repository.guardarEstado(gee);
    }

    public GarantiaEntity findByReserva(Long idReserva) {
        repository = new GarantiaRepository();

        return repository.findByReserva(idReserva);
    }

    public GarantiaEstadoEntity getEstado(Long idGarantia) {
        repository = new GarantiaRepository();

        return repository.getEstado(idGarantia);
    }

}
