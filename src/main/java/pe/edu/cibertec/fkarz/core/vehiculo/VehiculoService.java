package pe.edu.cibertec.fkarz.core.vehiculo;

import java.util.Date;
import java.util.List;

public class VehiculoService {

	private VehiculoRepository vr = null;

	public List<VehiculoEntity> findAvailable(Date fecha_inicio, Date fecha_fin) {
		vr = new VehiculoRepository();
		return vr.findAvailable(fecha_inicio, fecha_fin);
	}

	public VehiculoEntity findByNroRegistro(String nroRegistro) {
		vr = new VehiculoRepository();
		return vr.findByNoRegistro(nroRegistro);
	}

}
