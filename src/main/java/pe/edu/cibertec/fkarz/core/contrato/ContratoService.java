package pe.edu.cibertec.fkarz.core.contrato;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.util.Estado;

public class ContratoService {

    private ContratoRepository repository;
    private ReservaService reservaService;

    public ContratoEntity findByReserva(Long idReserva) {
        repository = new ContratoRepository();
        return repository.findByReserva(idReserva);
    }

    public ContratoEntity guardar(String uri, Long idReserva) throws Exception {
        repository = new ContratoRepository();
        reservaService = new ReservaService();

        if (uri == null | uri.isEmpty()) {
            throw new Exception("El archivo es invalido");
        }

        ReservaEntity reserva = reservaService.findById(idReserva);

        ContratoEntity contrato = new ContratoEntity();
        contrato.setReserva(reserva);
        contrato.setUri("http://notariagomila.cl/DOCTOS/CVeFINAL.pdf");

        reservaService.guardarEstado(Estado.CONTRATADO.val(), reserva);

        return repository.guardar(contrato);
    }
}
