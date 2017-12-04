package pe.edu.cibertec.fkarz.intranet.reserva;

import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.util.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/intranet/reserva/buscar")
public class ReservaBuscarIntranetServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ReservaService reservaService;

    public static final String ACTION_FINDBYRESERVA = "findByReserva";
    public static final String ACTION_FINDBYSUSCRIPTOR = "findBySuscriptor";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case ACTION_FINDBYSUSCRIPTOR:
                this.doGetFindBySuscriptor(request, response);
                break;
            default:
                this.doGetDefault(request, response);
                break;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    private void doGetDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/reserva/buscar.jsp");
        rd.forward(request, response);
    }

    private void doGetFindBySuscriptor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reservaService = new ReservaService();
        String valor = request.getParameter("valor");

        try {
            List<ReservaEntity> res = reservaService.findBySuscriptor(valor);
            request.setAttribute("reservas", res);
        } catch (Exception e) {
            Error.handler(request, e);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/reserva/buscar_result.jsp");
        rd.forward(request, response);
    }
}
