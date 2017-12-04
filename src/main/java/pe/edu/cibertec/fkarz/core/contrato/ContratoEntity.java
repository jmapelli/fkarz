package pe.edu.cibertec.fkarz.core.contrato;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contrato")
public class ContratoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uri;

    @ManyToOne(targetEntity = ReservaEntity.class)
    @JoinColumn(name = "RESERVA", nullable = false)
    private ReservaEntity reserva;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaRegistro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
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
