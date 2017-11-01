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

@WebServlet(urlPatterns = "/extranet/buscar")
public class BuscarExtranetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BuscarExtranetService bes = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fecha_inicio = req.getParameter("fecha_inicio");
		String fecha_fin = req.getParameter("fecha_fin");

		try {
			bes = new BuscarExtranetService();
			List<VehiculoEntity> ves = bes.findVehiculos(fecha_inicio, fecha_fin);

			req.setAttribute("vehiculos", ves);
			req.setAttribute("fecha_inicio", fecha_inicio);
			req.setAttribute("fecha_fin", fecha_fin);
		} catch (Exception e) {
			Error.handler(req, e);
		}

		RequestDispatcher rd = req.getRequestDispatcher("/template/extranet/buscar.jsp");
		rd.forward(req, res);
	}

}
