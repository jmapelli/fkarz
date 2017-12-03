package pe.edu.cibertec.fkarz.core.pago;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "pago")
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nroVoucher;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private String motivo;

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

    public String getNroVoucher() {
        return nroVoucher;
    }

    public void setNroVoucher(String nroVoucher) {
        this.nroVoucher = nroVoucher;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        this.nroVoucher = UUID.randomUUID().toString();
        this.fechaRegistro = new Date();
    }

}
