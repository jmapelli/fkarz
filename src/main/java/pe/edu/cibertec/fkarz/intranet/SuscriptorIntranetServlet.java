package pe.edu.cibertec.fkarz.intranet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/intranet/suscriptor")
public class SuscriptorIntranetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ACTION_CREAR = "guardar";
	public static final String ACTION_EDITAR = "editar";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		switch (action) {
		case ACTION_CREAR:
			this.crear(request, response);
			break;
		case ACTION_EDITAR:
			this.editar(request, response);
			break;
		default:
			this.listar(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/suscriptor/listar.jsp");
		rd.forward(request, response);
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/suscriptor/guardar.jsp");
		rd.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/suscriptor/editar.jsp");
		rd.forward(request, response);
	}

}
