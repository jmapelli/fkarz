package pe.edu.cibertec.fkarz.core.reserva;

import java.util.Date;

public class ReservaService {

	private ReservaRepository rr = null;

	public double calcSubTotal(Date fecha_inicio, Date fecha_fin, double precio) {
		int cant_dias = ((int) (fecha_fin.getTime() - fecha_inicio.getTime()) / 86400000) + 1;
		return cant_dias * precio;
	}
}
