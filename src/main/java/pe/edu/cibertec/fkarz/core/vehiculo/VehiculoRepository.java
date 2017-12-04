package pe.edu.cibertec.fkarz.core.vehiculo;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.edu.cibertec.fkarz.db.Connection;

public class VehiculoRepository {

	private static final Logger LOG = Logger.getLogger(VehiculoRepository.class.getName());
	private EntityManager em;

	public List<VehiculoEntity> findAvailable(Date fecha_inicio, Date fecha_fin) {
		List<VehiculoEntity> ves = null;
		try {
			em = Connection.getInstance();

			String sql = "select v.* from vehiculo v " + "left join reserva_vehiculo rv on rv.VEHICULO = v.id "
					+ "and rv.FECHARESERVADA between ? and ? " + "where rv.ID is null";

			Query query = em.createNativeQuery(sql, VehiculoEntity.class);
			query.setParameter(1, fecha_inicio);
			query.setParameter(2, fecha_fin);

			ves = (List<VehiculoEntity>) query.getResultList();
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}

		return ves;
	}

	public VehiculoEntity findByNoRegistro(String nroRegistro) {
		VehiculoEntity ve = null;

		try {
			em = Connection.getInstance();

			Query query = em.createNativeQuery("select * from vehiculo where nroregistro like ?", VehiculoEntity.class);
			query.setParameter(1, nroRegistro);

			ve = (VehiculoEntity) query.getSingleResult();
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}

		return ve;
	}

	public VehiculoEntity save(VehiculoEntity vehiculoEntity){
		try {
			em = Connection.getInstance();
			em.getTransaction().begin();
			em.persist(vehiculoEntity);
			em.getTransaction().commit();
		} catch (Exception e) {
			vehiculoEntity = null;
			LOG.warning(e.getLocalizedMessage());
		}

		return vehiculoEntity;

	}

}
