package pe.edu.cibertec.fkarz.core.vehiculo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VehiculoService {

    private VehiculoRepository repository = null;

    public List<VehiculoEntity> findAvailable(Date fecha_inicio, Date fecha_fin) {
        repository = new VehiculoRepository();
        return repository.findAvailable(fecha_inicio, fecha_fin);
    }

    public VehiculoEntity findByNroRegistro(String nroRegistro) {
        repository = new VehiculoRepository();
        return repository.findByNoRegistro(nroRegistro);
    }

    public List<VehiculoEntity> findVehiculos(String fecha_inicio, String fecha_fin) throws Exception {
        this.validateRequestBuscar(fecha_inicio, fecha_fin);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date inicio = df.parse(fecha_inicio);
        Date fin = df.parse(fecha_fin);

        List<VehiculoEntity> ves = this.findAvailable(inicio, fin);

        this.validateResultadosBuscar(ves);

        return ves;
    }

    public void validateRequestBuscar(String fecha_inicio, String fecha_fin) throws Exception {
        if (fecha_inicio.isEmpty() || fecha_fin.isEmpty()) {
            throw new Exception("Los campos son invalidos");
        }
    }

    public void validateResultadosBuscar(List<VehiculoEntity> ves) throws Exception {
        if (ves == null || ves.isEmpty()) {
            throw new Exception("No hay vehiculos disponibles");
        }
    }

    public void save(VehiculoEntity vehiculoEntity) throws Exception {
        repository = new VehiculoRepository();
        vehiculoEntity = repository.save(vehiculoEntity);

        if(vehiculoEntity == null){
            throw new Exception("Nro de registro duplicado");
        }
    }

    public VehiculoEntity findByReserva(Long idReserva) {
        repository = new VehiculoRepository();

        return repository.findByReserva(idReserva);
    }

}
