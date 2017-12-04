package pe.edu.cibertec.fkarz.intranet;

import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoService;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/intranet/vehiculo")
public class VehiculoIntranetServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(VehiculoIntranetServlet.class.getName());
	public static final String ACTION_CREAR = "crear";
	public static final String ACTION_GUARDAR = "guardar";
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
		case ACTION_GUARDAR:
				this.guardar(request, response);
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
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/vehiculo/listar.jsp");
		rd.forward(request, response);
	}

	private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/vehiculo/crear.jsp");
		rd.forward(request, response);
	}

	private void guardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "OK";

		try{

			String nroRegistro = request.getParameter("nroRegistro");
			String marca = request.getParameter("marca");
			String modelo = request.getParameter("modelo");
			String anio = request.getParameter("anio");
			String color = request.getParameter("color");
			String foto = request.getParameter("foto");
			String combustible = request.getParameter("combustible");
			String precio = request.getParameter("precio");

			VehiculoEntity vehiculoEntity = new VehiculoEntity();
			vehiculoEntity.setNroRegistro(nroRegistro);
			vehiculoEntity.setMarca(marca);
			vehiculoEntity.setModelo(modelo);
			vehiculoEntity.setAnio(anio);
			vehiculoEntity.setColor(color);
			vehiculoEntity.setFoto(foto);
			vehiculoEntity.setCombustible(combustible);
			vehiculoEntity.setPrecio(Double.parseDouble(precio));

			VehiculoService vehiculoService = new VehiculoService();
			vehiculoService.save(vehiculoEntity);


		}catch (Exception e){
			result = "ERROR";
			LOG.warning(e.getMessage());
		}

		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/vehiculo/guardar.jsp");
		rd.forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/vehiculo/editar.jsp");
		rd.forward(request, response);
	}

}
