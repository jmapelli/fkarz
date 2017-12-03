package pe.edu.cibertec.fkarz.core.pago;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaRepository;
import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

public class PagoRepository {

    private static final Logger LOG = Logger.getLogger(PagoRepository.class.getName());
    private EntityManager em;

    public PagoEntity guardar(PagoEntity entity) {
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
