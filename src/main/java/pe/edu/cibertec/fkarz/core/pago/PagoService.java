package pe.edu.cibertec.fkarz.core.pago;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;

public class PagoService {

    private PagoRepository repository;

    public PagoEntity guardar(String motivo, ReservaEntity reserva) throws Exception {
        repository = new PagoRepository();

        PagoEntity pe = new PagoEntity();
        pe.setReserva(reserva);
        pe.setMonto(reserva.getTotal());
        pe.setMotivo(motivo);

        return repository.guardar(pe);
    }
}
