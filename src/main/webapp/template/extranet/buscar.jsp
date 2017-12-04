<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity" %>
<%@page import="pe.edu.cibertec.fkarz.extranet.BuscarExtranetServlet" %>
<%@page import="java.util.List" %>
<%@ page import="pe.edu.cibertec.fkarz.util.Error" %>

<%
    if (request.getAttribute("error_status") != null
            && request.getAttribute("error_status").equals(Error.ERROR_STATUS_OK)) {
%>
<%=request.getAttribute("error_message")%>
<%
} else {
    List<VehiculoEntity> vehiculos = (List) request.getAttribute("vehiculos");
    for (VehiculoEntity vehiculo : vehiculos) {
%>
<div class="col-lg-4 col-md-4 col-sm-4 mb">
    <form id="<%=vehiculo.getNroRegistro()%>" action="extranet/buscar" method="post">
        <input type="hidden" name="action" value="<%=BuscarExtranetServlet.ACTION_SELECCIONAR%>">
        <input type="hidden" name="vehiculo" value="<%=vehiculo.getNroRegistro()%>">
        <input type="hidden" name="fecha_inicio" value="<%=request.getAttribute("fecha_inicio")%>">
        <input type="hidden" name="fecha_fin" value="<%=request.getAttribute("fecha_fin")%>">
        <div class="content-panel pn stock card" style="height: 380px;">
            <div id="profile-01"
                 style="min-height: 180px; background: url(<%=vehiculo.getFoto()%>); background-repeat: no-repeat; background-size: cover; background-position: center;">
            </div>
            <div class="profile-01 centered reservar" data-form="<%=vehiculo.getNroRegistro()%>">
                <p>RESERVAR</p>
            </div>

            <div class="summary centered" style="background-color: #fff;">
                <strong>MARCA:</strong> <span><%=vehiculo.getMarca()%></span>
            </div>
        </div>
    </form>
</div>
<%
        }
    }
%>

<script type="text/javascript">
    $(function () {
        $('.reservar').click(function (e) {
            e.preventDefault();

            var form_name = $(this).data('form');
            $('#' + form_name).submit();
        });
    });
</script>
