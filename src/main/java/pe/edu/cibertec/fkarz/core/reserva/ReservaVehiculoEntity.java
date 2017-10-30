package pe.edu.cibertec.fkarz.core.reserva;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;

@Entity
@Table(name = "reserva_vehiculo")
public class ReservaVehiculoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaReservada;

	@Column(nullable = false)
	private double precio;

	@ManyToOne(targetEntity = VehiculoEntity.class)
	@JoinColumn(name = "VEHICULO", nullable = false)
	private VehiculoEntity vehiculo;

	@ManyToOne(targetEntity = ReservaEntity.class)
	@JoinColumn(name = "RESERVA", nullable = false)
	private ReservaEntity reserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaReservada() {
		return fechaReservada;
	}

	public void setFechaReservada(Date fechaReservada) {
		this.fechaReservada = fechaReservada;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public ReservaEntity getReserva() {
		return reserva;
	}

	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}

}
