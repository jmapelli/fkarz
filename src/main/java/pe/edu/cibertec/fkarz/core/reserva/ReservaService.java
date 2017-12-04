package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaService;
import pe.edu.cibertec.fkarz.core.pago.PagoService;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.util.DateUtil;
import pe.edu.cibertec.fkarz.util.Estado;

import java.util.Date;

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

    public ReservaEntity reservar(VehiculoEntity vehiculo, ReservaEntity reserva) throws Exception {
        garantiaService = new GarantiaService();
        pagoService = new PagoService();

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
        ReservaVehiculoEntity rve = new ReservaVehiculoEntity();
        rve.setFechaReservada(fecha);
        rve.setVehiculo(vehiculo);
        rve.setReserva(reserva);
        rve.setPrecio(vehiculo.getPrecio());

        return repository.guardarDetalle(rve);
    }

    public void guardarEstado(int estado, ReservaEntity reserva) throws Exception {
        ReservaEstadoEntity ree = new ReservaEstadoEntity();
        ree.setReserva(reserva);
        ree.setEstado(estado);

        repository.guardarEstado(ree);
    }
}
