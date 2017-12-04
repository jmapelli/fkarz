package pe.edu.cibertec.fkarz.intranet;

import pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity;
import pe.edu.cibertec.fkarz.util.Rol;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/intranet", "/intranet/"})
public class IndexIntranetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioEntity usuario = (UsuarioEntity) request.getSession().getAttribute("usuario");

        if (usuario.getRol() == Rol.SUSCRIPTOR.val()) {
            response.sendRedirect(request.getContextPath());
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/template/intranet/index.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
