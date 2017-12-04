package pe.edu.cibertec.fkarz.intranet.reserva;

import pe.edu.cibertec.fkarz.core.contrato.ContratoEntity;
import pe.edu.cibertec.fkarz.core.contrato.ContratoService;
import pe.edu.cibertec.fkarz.core.garantia.GarantiaEntity;
import pe.edu.cibertec.fkarz.core.garantia.GarantiaEstadoEntity;
import pe.edu.cibertec.fkarz.core.garantia.GarantiaService;
import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaEstadoEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaPenalizacionEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoService;
import pe.edu.cibertec.fkarz.util.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ReservaVerIntranetServlet", urlPatterns = "/intranet/reserva/ver")
public class ReservaVerIntranetServlet extends HttpServlet {

    private ReservaService reservaService;
    private GarantiaService garantiaService;
    private VehiculoService vehiculoService;
    private ContratoService contratoService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        reservaService = new ReservaService();
        garantiaService = new GarantiaService();
        vehiculoService = new VehiculoService();
        contratoService = new ContratoService();
        RequestDispatcher rd = null;

        UsuarioEntity usuario = (UsuarioEntity) request.getSession().getAttribute("usuario");
        Long idReserva = Long.parseLong(request.getParameter("idReserva"));

        try {
            ReservaEntity reserva = reservaService.findById(idReserva);
            ReservaEstadoEntity reserva_estado = reservaService.getEstado(reserva);
            GarantiaEntity garantia = garantiaService.findByReserva(reserva.getId());
            GarantiaEstadoEntity garantia_estado = garantiaService.getEstado(garantia.getId());
            VehiculoEntity vehiculo = vehiculoService.findByReserva(reserva.getId());
            ContratoEntity contrato = contratoService.findByReserva(reserva.getId());
            List<ReservaPenalizacionEntity> penalizaciones = reservaService.getPenalizaciones(reserva.getId());

            request.setAttribute("reserva", reserva);
            request.setAttribute("reserva_estado", reserva_estado);
            request.setAttribute("garantia", garantia);
            request.setAttribute("garantia_estado", garantia_estado);
            request.setAttribute("vehiculo", vehiculo);
            request.setAttribute("contrato", contrato);
            request.setAttribute("penalizaciones", penalizaciones);

            switch (usuario.getRol()) {
                case 2:
                    rd = request.getRequestDispatcher("/template/intranet/reserva/registrar_contrato.jsp");
                    break;
                case 3:
                    rd = request.getRequestDispatcher("/template/intranet/reserva/ver_cajero.jsp");
                    break;
                case 4:
                    rd = request.getRequestDispatcher("/template/intranet/reserva/ver_tecnico.jsp");
                    break;
            }
        } catch (Exception e) {
            Error.handler(request, e);
        }

        rd.forward(request, response);
    }

}
