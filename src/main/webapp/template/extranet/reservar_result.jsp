<%@ page import="pe.edu.cibertec.fkarz.core.reserva.ReservaEntity" %><%--
  Created by IntelliJ IDEA.
  User: JosueAngel
  Date: 02/12/2017
  Time: 12:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%
    ReservaEntity reserva = (ReservaEntity) request.getSession().getAttribute("reserva");
    String error_message = (String) request.getAttribute("error_message");
%>

<% if (error_message != null) { %>
<div class="alert alert-danger alert-dismissable"
     style="margin-bottom: 10px; text-align: left">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
    </button>
    <%=error_message%>
</div>
<% } else {%>
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" style="text-align: center">Confirmación</h4>
            </div>
            <div class="modal-body" style="text-align: center;">
                <h5>La reserva ha sido creada correctamente</h5>
            </div>
            <div class="modal-footer">
                <button id="finalizar" type="button" class="btn btn-default" data-dismiss="modal">Finalizar</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {
        $('#modal').modal({
            backdrop: 'static',
            keyboard: false,
            show: true
        });

        $('#finalizar').click(function () {
            document.location.href = '<%=request.getContextPath()%>';
        });
    })
</script>
<% } %>