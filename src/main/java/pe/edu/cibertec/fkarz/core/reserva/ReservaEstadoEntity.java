package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaEntity;
import pe.edu.cibertec.fkarz.core.recurso.RecursoEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva_estado")
public class ReservaEstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
