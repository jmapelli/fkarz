package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaService;
import pe.edu.cibertec.fkarz.core.pago.PagoService;
import pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.util.DateUtil;
import pe.edu.cibertec.fkarz.util.Estado;

import java.util.Date;
import java.util.List;

public class ReservaService {

    private ReservaRepository repository = null;
    private GarantiaService garantiaService = null;
    private PagoService pagoService = null;

    public ReservaEntity generar(Date fecha_inicio, Date fecha_fin, VehiculoEntity vehiculo) {
        ReservaEntity re = new ReservaEntity();
        re.setFechaInicio(fecha_inicio);
        re.setFechaFin(fecha_fin);
        re.setTotal(this.calcTotal(re.getFechaInicio(), re.getFechaFin(), vehiculo.getPrecio()));

        return re;
    }

    private double calcTotal(Date fecha_inicio, Date fecha_fin, double precio) {
        int cant_dias = DateUtil.getCountDays(fecha_inicio, fecha_fin);
        return cant_dias * precio;
    }

    public void cobrar(String tarjeta, String fechaExpiracion, String cvv) throws Exception {
        if (tarjeta == null || tarjeta.isEmpty()) {
            throw new Exception("La tarjeta es invalida");
        }

        if (fechaExpiracion == null || fechaExpiracion.isEmpty()) {
            throw new Exception("La fecha es invalida");
        }

        if (cvv == null || cvv.isEmpty()) {
            throw new Exception("El codigo cvv es necesario");
        }
    }

    public ReservaEntity reservar(VehiculoEntity vehiculo, ReservaEntity reserva, UsuarioEntity suscriptor) throws Exception {
        garantiaService = new GarantiaService();
        pagoService = new PagoService();

        reserva.setSuscriptor(suscriptor);
        reserva = this.guardar(reserva);

        Date fecha = null;
        int cant_dias = DateUtil.getCountDays(reserva.getFechaInicio(), reserva.getFechaFin());
        for (int i = 0; i < cant_dias; i++) {
            fecha = DateUtil.addDays(reserva.getFechaInicio(), i);
            this.guardarDetalle(fecha, vehiculo, reserva);
        }

        garantiaService.guardar(reserva);
        pagoService.guardar("Pago por reservar", reserva);

        return reserva;
    }

    public ReservaEntity guardar(ReservaEntity reserva) throws Exception {
        repository = new ReservaRepository();

        reserva = repository.guardar(reserva);
        this.guardarEstado(Estado.ACTIVO.val(), reserva);

        return reserva;
    }

    public ReservaVehiculoEntity guardarDetalle(Date fecha, VehiculoEntity vehiculo, ReservaEntity reserva) throws Exception {
        repository = new ReservaRepository();

        ReservaVehiculoEntity rve = new ReservaVehiculoEntity();
        rve.setFechaReservada(fecha);
        rve.setVehiculo(vehiculo);
        rve.setReserva(reserva);
        rve.setPrecio(vehiculo.getPrecio());

        return repository.guardarDetalle(rve);
    }

    public void guardarEstado(int estado, ReservaEntity reserva) throws Exception {
        repository = new ReservaRepository();

        ReservaEstadoEntity ree = new ReservaEstadoEntity();
        ree.setReserva(reserva);
        ree.setEstado(estado);

        repository.guardarEstado(ree);
    }

    public List<ReservaEntity> findBySuscriptor(String nroDocumento) throws Exception {
        repository = new ReservaRepository();

        if (nroDocumento == null) {
            throw new Exception("El nro. de documento es invalido");
        }

        return repository.findBySuscriptor(nroDocumento);
    }

    public ReservaEntity findById(Long id) throws Exception {
        repository = new ReservaRepository();

        return repository.findById(id);
    }

    public ReservaEstadoEntity getEstado(ReservaEntity reserva) {
        repository = new ReservaRepository();
        return repository.getEstado(reserva);
    }

    public List<ReservaPenalizacionEntity> getPenalizaciones(Long idReserva) {
        repository = new ReservaRepository();
        return repository.getPenalizaciones(idReserva);
    }
}
