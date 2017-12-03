package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "garantia")
public class GarantiaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double monto;

    @ManyToOne(targetEntity = ReservaEntity.class)
    @JoinColumn(name = "RESERVA", nullable = false)
    private ReservaEntity reserva;

    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
