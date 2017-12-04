package pe.edu.cibertec.fkarz.intranet.reserva;

import pe.edu.cibertec.fkarz.core.contrato.ContratoEntity;
import pe.edu.cibertec.fkarz.core.contrato.ContratoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReservaContratoIntranetServlet", urlPatterns = "/intranet/reserva/contrato")
public class ReservaContratoIntranetServlet extends HttpServlet {

    private ContratoService contratoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        contratoService = new ContratoService();

        String file = request.getParameter("file");
        String idReserva = request.getParameter("reserva");

        try {
            ContratoEntity contrato = contratoService.guardar(file, Long.parseLong(idReserva));

            request.setAttribute("contrato", contrato);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/reserva/registrar_contrato_result.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
