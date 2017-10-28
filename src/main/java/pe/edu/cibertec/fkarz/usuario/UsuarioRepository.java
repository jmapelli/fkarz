package pe.edu.cibertec.fkarz.usuario;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.edu.cibertec.fkarz.db.Connection;

public class UsuarioRepository {

	private static final Logger LOG = Logger.getLogger(UsuarioRepository.class.getName());
	private EntityManager em;

	public UsuarioEntity findByUsername(String username) {
		UsuarioEntity ue = null;

		try {
			em = Connection.getInstance();

			Query q = em.createQuery("Select ue from UsuarioEntity ue where ue.username like :username");
			q.setParameter("username", username);

			ue = (UsuarioEntity) q.getSingleResult();
		} catch (Exception e) {
			LOG.warning(e.getLocalizedMessage());
		}

		return ue;
	}

}
