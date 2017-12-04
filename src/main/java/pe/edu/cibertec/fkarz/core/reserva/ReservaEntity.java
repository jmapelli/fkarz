package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

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
    private double total;

    @ManyToOne(targetEntity = UsuarioEntity.class)
    @JoinColumn(name = "suscriptor", nullable = false)
    private UsuarioEntity suscriptor;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UsuarioEntity getSuscriptor() {
        return suscriptor;
    }

    public void setSuscriptor(UsuarioEntity suscriptor) {
        this.suscriptor = suscriptor;
    }

    @PrePersist
    private void prePersist() {
        this.nroOrden = UUID.randomUUID().toString();
    }
}
