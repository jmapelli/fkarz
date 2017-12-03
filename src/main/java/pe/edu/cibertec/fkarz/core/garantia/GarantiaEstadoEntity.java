package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.core.recurso.RecursoEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "garantia_estado")
public class GarantiaEstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = GarantiaEntity.class)
    @JoinColumn(name = "GARANTIA", nullable = false)
    private GarantiaEntity garantia;

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

    public GarantiaEntity getGarantia() {
        return garantia;
    }

    public void setGarantia(GarantiaEntity garantia) {
        this.garantia = garantia;
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
