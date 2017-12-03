package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.db.Connection;

import java.util.logging.Logger;

import javax.persistence.EntityManager;

public class ReservaRepository {

    private static final Logger LOG = Logger.getLogger(ReservaRepository.class.getName());
    private EntityManager em;


    public ReservaEntity guardar(ReservaEntity entity) {
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

    public ReservaVehiculoEntity guardarDetalle(ReservaVehiculoEntity entity) {
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

    public ReservaEstadoEntity guardarEstado(ReservaEstadoEntity entity) {
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
