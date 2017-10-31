package pe.edu.cibertec.fkarz.extranet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HttpMethod;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoService;
import pe.edu.cibertec.fkarz.util.Error;

@WebServlet(urlPatterns = "/extranet/reservar")
public class ReservarExtranetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VehiculoService vs = null;
	private ReservaService rs = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/template/extranet/reservar.jsp");
		rd.forward(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			vs = new VehiculoService();
			rs = new ReservaService();

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			VehiculoEntity ve = vs.findByNroRegistro(req.getParameter("vehiculo"));

			ReservaEntity re = new ReservaEntity();
			re.setFechaInicio(df.parse(req.getParameter("fecha_inicio")));
			re.setFechaFin(df.parse(req.getParameter("fecha_fin")));
			re.setSubTotal(rs.calcSubTotal(re.getFechaInicio(), re.getFechaFin(), ve.getPrecio()));
			re.setGarantia(5000);
			re.setTotal(re.getSubTotal() + re.getGarantia());

			req.getSession().setAttribute("vehiculo", ve);
			req.getSession().setAttribute("reserva", re);
		} catch (Exception e) {
			Error.handler(req, e);
		}

		res.sendRedirect(req.getContextPath() + "/extranet/reservar");
	}

}
