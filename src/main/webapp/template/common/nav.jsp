<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="pe.edu.cibertec.fkarz.auth.AuthServlet" %>
<%@ page import="pe.edu.cibertec.fkarz.core.usuario.UsuarioEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.util.Rol" %>

<%
    UsuarioEntity usuario = (UsuarioEntity) request.getSession().getAttribute("usuario");
%>

<header class="header black-bg">
    <a href="" class="logo"><b>F-KARZ</b></a>

    <%
        if (request.getSession().getAttribute("authenticated") != null && usuario.getRol() == Rol.SUSCRIPTOR.val()) {
    %>
    <div class="top-menu">

        <ul class="nav pull-right notify-row top-menu" style="display: block;">
            <li class="dropdown"><a data-toggle="dropdown"
                                    class="dropdown-toggle" href="#" style="margin: 0"> <i
                    class="fa fa-user"></i>
            </a>
                <ul class="dropdown-menu extended tasks-bar inbox"
                    style="left: auto; right: 0">
                    <div class="notify-arrow notify-arrow-green"
                         style="left: auto; right: 5px"></div>
                    <li>
                        <p class="green">Bienvenido!</p>
                    </li>

                    <li><a href="#"> <span class="photo"><img
                            alt="avatar" src="<%=request.getContextPath()%>/assets/img/ui-danro.jpg"></span> <span
                            class="subject"> <span class="from">Josue Mapelli</span>
						</span> <span class="message">kxel@outlook.com</span>
                    </a></li>

                    <li><a class="logout" href="#">Mis reservas</a></li>
                    <li><a class="logout"
                           href="<%=request.getContextPath()%>/auth?action=<%=AuthServlet.ACTION_LOGOUT%>">Cerrar
                        sesi�n</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <%
        }
    %>

</header>