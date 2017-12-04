package pe.edu.cibertec.fkarz.core.reserva;

import pe.edu.cibertec.fkarz.db.Connection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

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


    public List<ReservaEntity> findBySuscriptor(String nroDocumento) {
        List<ReservaEntity> res = null;

        try {
            em = Connection.getInstance();

            String sql = "select r from ReservaEntity r " +
                    "inner join r.suscriptor s " +
                    "where s.nroDocumento like :nroDocumento ";

            Query q = em.createQuery(sql);
            q.setParameter("nroDocumento", nroDocumento);

            res = (List<ReservaEntity>) q.getResultList();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return res;
    }

    public ReservaEstadoEntity getEstado(ReservaEntity reserva) {
        ReservaEstadoEntity estado = null;

        try {
            em = Connection.getInstance();

            String sql = "select re.* from reserva_estado re " +
                    "inner join reserva r on r.id = re.reserva " +
                    "where r.id = ? " +
                    "order by re.fecharegistro DESC " +
                    "limit 1 ";

            Query q = em.createNativeQuery(sql, ReservaEstadoEntity.class);
            q.setParameter(1, reserva.getId());

            estado = (ReservaEstadoEntity) q.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return estado;
    }

    public ReservaEntity findById(Long id) {
        ReservaEntity re = null;

        try {
            em = Connection.getInstance();

            String sql = "select * from reserva where id = ? ";

            Query q = em.createNativeQuery(sql, ReservaEntity.class);
            q.setParameter(1, id);

            re = (ReservaEntity) q.getSingleResult();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return re;
    }

    public List<ReservaPenalizacionEntity> getPenalizaciones(Long idReserva) {
        List<ReservaPenalizacionEntity> penas = null;

        try {
            em = Connection.getInstance();

            String sql = "select * from reserva_penalizacion where reserva = ? ";

            Query q = em.createNativeQuery(sql, ReservaPenalizacionEntity.class);
            q.setParameter(1, idReserva);

            penas = (List<ReservaPenalizacionEntity>) q.getResultList();
        } catch (Exception e) {
            LOG.warning(e.getMessage());
        }

        return penas;
    }

}
