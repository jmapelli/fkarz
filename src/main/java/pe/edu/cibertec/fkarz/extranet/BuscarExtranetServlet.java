package pe.edu.cibertec.fkarz.extranet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.edu.cibertec.fkarz.core.garantia.GarantiaEntity;
import pe.edu.cibertec.fkarz.core.garantia.GarantiaService;
import pe.edu.cibertec.fkarz.core.reserva.ReservaEntity;
import pe.edu.cibertec.fkarz.core.reserva.ReservaService;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity;
import pe.edu.cibertec.fkarz.core.vehiculo.VehiculoService;
import pe.edu.cibertec.fkarz.util.DateUtil;
import pe.edu.cibertec.fkarz.util.Error;

@WebServlet(urlPatterns = "/extranet/buscar")
public class BuscarExtranetServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private VehiculoService vs = null;
    private ReservaService rs = null;

    public static final String ACTION_SELECCIONAR = "seleccionar";

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGetBuscar(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case ACTION_SELECCIONAR:
                this.doPostSeleccionar(req, res);
                break;
        }
    }

    private void doGetBuscar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fecha_inicio = req.getParameter("fecha_inicio");
        String fecha_fin = req.getParameter("fecha_fin");

        try {
            vs = new VehiculoService();
            List<VehiculoEntity> ves = vs.findVehiculos(fecha_inicio, fecha_fin);

            req.setAttribute("vehiculos", ves);
            req.setAttribute("fecha_inicio", fecha_inicio);
            req.setAttribute("fecha_fin", fecha_fin);
        } catch (Exception e) {
            Error.handler(req, e);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/template/extranet/buscar.jsp");
        rd.forward(req, res);
    }

    private void doPostSeleccionar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            vs = new VehiculoService();
            rs = new ReservaService();

            Date fecha_inicio = DateUtil.toDate("yyyy-MM-dd", req.getParameter("fecha_inicio"));
            Date fecha_fin = DateUtil.toDate("yyyy-MM-dd", req.getParameter("fecha_fin"));
            String nroRegistro = req.getParameter("vehiculo");

            VehiculoEntity ve = vs.findByNroRegistro(nroRegistro);
            ReservaEntity re = rs.generar(fecha_inicio, fecha_fin, ve);

            req.getSession().setAttribute("vehiculo", ve);
            req.getSession().setAttribute("reserva", re);
        } catch (Exception e) {
            Error.handler(req, e);
        }

        res.sendRedirect(req.getContextPath() + "/extranet/reservar");
    }

}
