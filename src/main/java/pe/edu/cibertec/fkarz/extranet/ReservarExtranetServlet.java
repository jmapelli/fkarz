package pe.edu.cibertec.fkarz.extranet;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.util.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/extranet/reservar")
public class ReservarExtranetServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ReservaService rs = null;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/template/extranet/reservar.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rs = new ReservaService();

        VehiculoEntity vehiculo = (VehiculoEntity) request.getSession().getAttribute("vehiculo");
        ReservaEntity reserva = (ReservaEntity) request.getSession().getAttribute("reserva");
        String nroTarjeta = request.getParameter("nroTarjeta");
        String fechaExpiracion = request.getParameter("fechaExpiracion");
        String cvv = request.getParameter("cvv");

        try {
            rs.cobrar(nroTarjeta, fechaExpiracion, cvv);
            rs.reservar(vehiculo, reserva);

            request.getSession().removeAttribute("vehiculo");
            request.getSession().removeAttribute("reserva");
        } catch (Exception e) {
            Error.handler(request, e);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/template/extranet/reservar_result.jsp");
        rd.forward(request, response);
    }

}
