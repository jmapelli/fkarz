package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Logger;

public class GarantiaRepository {

    private static final Logger LOG = Logger.getLogger(GarantiaRepository.class.getName());
    private EntityManager em;

    public GarantiaEntity guardar(GarantiaEntity entity) {
        try {
            em = Connection.getInstance();

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.warning(e.getLocalizedMessage());
        }

        return entity;
    }

    public GarantiaEstadoEntity guardarEstado(GarantiaEstadoEntity entity) {
        try {
            em = Connection.getInstance();

            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            LOG.warning(e.getLocalizedMessage());
        }

        return entity;
    }

    public GarantiaEntity findByReserva(Long idReserva) {
        GarantiaEntity ge = null;

        try {
            em = Connection.getInstance();

            String sql = "select * from garantia where reserva = ? ";

            Query q = em.createNativeQuery(sql, GarantiaEntity.class);
            q.setParameter(1, idReserva);

            ge = (GarantiaEntity) q.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return ge;
    }

    public GarantiaEstadoEntity getEstado(Long idGarantia) {
        GarantiaEstadoEntity ge = null;

        try {
            em = Connection.getInstance();

            String sql = "select * from garantia_estado " +
                    "where garantia = ? " +
                    "order by fechaRegistro DESC " +
                    "limit 1";

            Query q = em.createNativeQuery(sql, GarantiaEstadoEntity.class);
            q.setParameter(1, idGarantia);

            ge = (GarantiaEstadoEntity) q.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return ge;
    }

}
