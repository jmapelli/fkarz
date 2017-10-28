package pe.edu.cibertec.fkarz.db;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(ConnectionListener.class.getName());

	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("########## Inicializando conexin con base de datos ##########");

		Connection.init();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("########## Cerrando conexin con base de datos ##########");
		Connection.close();

	}

}
