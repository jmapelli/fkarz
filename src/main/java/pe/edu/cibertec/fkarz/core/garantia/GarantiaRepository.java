package pe.edu.cibertec.fkarz.core.garantia;

import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
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

}
