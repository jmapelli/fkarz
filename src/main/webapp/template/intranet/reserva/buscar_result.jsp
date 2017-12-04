<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="pe.edu.cibertec.fkarz.util.DateUtil" %>
<%@ page import="pe.edu.cibertec.fkarz.util.Estado" %>
<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEstadoEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaService" %><%--
  Created by IntelliJ IDEA.
  User: JosueAngel
  Date: 04/12/2017
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%
    List<ReservaEntity> reservas = (List) request.getAttribute("reservas");
    String error_message = (String) request.getAttribute("error_message");
%>

<% if (error_message != null) { %>
<tr>
    <td colspan="6" style="background-color: #fff;">
        <div class="alert alert-danger alert-dismissable" style="margin-bottom: 10px; text-align: left">
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
            </button>
            <%=error_message%>
        </div>
    </td>
</tr>
<% } else if (!reservas.isEmpty()) {
    for (ReservaEntity reserva : reservas) {
        ReservaEstadoEntity estado = new ReservaService().getEstado(reserva);
%>
<tr>
    <td><%=reserva.getNroOrden()%>
    </td>
    <td><%=reserva.getSuscriptor().getNroDocumento()%>
    </td>
    <td><%=reserva.getSuscriptor().getNombres() + " " + reserva.getSuscriptor().getApellidos()%>
    </td>
    <td><%=DateUtil.toString("dd/MM/yyy", reserva.getFechaInicio())%>
    </td>
    <td><%=DateUtil.toString("dd/MM/yyy", reserva.getFechaFin())%>
    </td>
    <td><%=Estado.toString(estado.getEstado())%>
    </td>
    <td>
        <button class="ver btn btn-success btn-xs" data-id="<%=reserva.getId()%>">
            <i class="fa fa-sign-in"></i>
        </button>
    </td>
</tr>
<%
    }
} else { %>
<tr>
    <td colspan="6" style="background-color: #fff;">
        No se han encontrado citas
    </td>
</tr>
<% }%>

<script>
    $(function () {
        $('.ver').click(function () {
            document.location.href = '<%=request.getContextPath()%>/intranet/reserva/ver?idReserva=' + $(this).data('id');
        });
    });
</script>



