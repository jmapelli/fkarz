package pe.edu.cibertec.fkarz.core.reserva;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reserva")
public class ReservaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nroOrden;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaFin;

	@Column(nullable = false)
	private double subTotal;

	@Column(nullable = false)
	private double garantia;

	@Column(nullable = false)
	private double total;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date fechaRegistro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(String nroOrden) {
		this.nroOrden = nroOrden;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getGarantia() {
		return garantia;
	}

	public void setGarantia(double garantia) {
		this.garantia = garantia;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@PrePersist
	private void prePersist() {
		this.nroOrden = UUID.randomUUID().toString();
		this.fechaRegistro = new Date();
	}
}
