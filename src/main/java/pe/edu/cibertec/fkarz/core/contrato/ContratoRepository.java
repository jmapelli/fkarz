package pe.edu.cibertec.fkarz.core.contrato;

import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Logger;

public class ContratoRepository {

    private static final Logger LOG = Logger.getLogger(ContratoRepository.class.getName());
    private EntityManager em;

    public ContratoEntity findByReserva(Long idReserva) {
        ContratoEntity contrato = null;

        try {
            em = Connection.getInstance();

            String sql = "select * from contrato where reserva = ?";

            Query query = em.createNativeQuery(sql, ContratoEntity.class);
            query.setParameter(1, idReserva);

            contrato = (ContratoEntity) query.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return contrato;
    }

    public ContratoEntity guardar(ContratoEntity entity) {
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
