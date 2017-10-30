package pe.edu.cibertec.fkarz.extranet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.util.Error;

@WebServlet(urlPatterns = "/extranet")
public class IndexExtranetServlet extends HttpServlet {

	public static final String ACTION_SEARCH = "search";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action != null && !action.isEmpty()) {
			switch (action) {
			case ACTION_SEARCH:
				this.search(req, res);
				break;
			}
		}

	}

	private void search(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String fecha_inicio = req.getParameter("fecha_inicio");
		String fecha_fin = req.getParameter("fecha_fin");

		try {
			SearchService ss = new SearchService();
			List<VehiculoEntity> ves = ss.findVehiculos(fecha_inicio, fecha_fin);

			req.setAttribute("vehiculos", ves);
		} catch (Exception e) {
			Error.handler(req, e);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/template/extranet/result_for_index_search.jsp");
		rd.forward(req, res);
	}

}
