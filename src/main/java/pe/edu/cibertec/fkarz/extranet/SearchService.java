package pe.edu.cibertec.fkarz.extranet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoService;

public class SearchService {

	private VehiculoService vs;

	public List<VehiculoEntity> findVehiculos(String fecha_inicio, String fecha_fin) throws Exception {
		this.validateRequest(fecha_inicio, fecha_fin);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date inicio = df.parse(fecha_inicio);
		Date fin = df.parse(fecha_fin);

		vs = new VehiculoService();
		List<VehiculoEntity> ves = vs.findAvailable(inicio, fin);

		this.validateResultados(ves);

		return ves;
	}

	public void validateRequest(String fecha_inicio, String fecha_fin) throws Exception {
		if (fecha_inicio.isEmpty() || fecha_fin.isEmpty()) {
			throw new Exception("Los campos son invalidos");
		}
	}

	public void validateResultados(List<VehiculoEntity> ves) throws Exception {
		if (ves == null || ves.isEmpty()) {
			throw new Exception("No hay vehiculos disponibles");
		}
	}

}
