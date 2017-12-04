package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.core.recurso.RecursoEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva_penalizacion")
public class ReservaPenalizacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double precio;

    @ManyToOne(targetEntity = ReservaEntity.class)
    @JoinColumn(name = "RESERVA", nullable = false)
    private ReservaEntity reserva;

    @ManyToOne(targetEntity = RecursoEntity.class)
    @JoinColumn(name = "ESTADO", nullable = false)
    private RecursoEntity estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public RecursoEntity getEstado() {
        return estado;
    }

    public void setEstado(RecursoEntity estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @PrePersist
    private void prePersist() {
        this.fechaRegistro = new Date();
    }
}
