package pe.edu.cibertec.fkarz.core.recurso;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaRepository;
import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.logging.Logger;

public class RecursoRepository {

    private static final Logger LOG = Logger.getLogger(GarantiaRepository.class.getName());
    private EntityManager em;

    public RecursoEntity find(String valor, String categoria) {
        RecursoEntity ue = null;

        try {
            em = Connection.getInstance();

            String sql = "Select r from RecursoEntity r where r.valor like :valor and r.categoria like :categoria";

            Query q = em.createQuery(sql);
            q.setParameter("valor", valor);
            q.setParameter("categoria", categoria);

            ue = (RecursoEntity) q.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getLocalizedMessage());
        }

        return ue;
    }

}
