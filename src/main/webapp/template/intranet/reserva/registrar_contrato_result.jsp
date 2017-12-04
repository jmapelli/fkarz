<%@ page import="pe.edu.cibertec.fkarz.core.contrato.ContratoEntity" %>
<%@ page import="pe.edu.cibertec.fkarz.util.DateUtil" %><%--
  Created by IntelliJ IDEA.
  User: JosueAngel
  Date: 04/12/2017
  Time: 04:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%
    ContratoEntity contrato = (ContratoEntity) request.getAttribute("contrato");
%>

<div class="task-content" style="margin-bottom: 0; padding: 0">
    <table class="table table-striped" style="margin-bottom: 0">
        <tbody>
        <tr>
            <td><b>Registrado el:</b></td>
            <td style="text-align: right;"><%=DateUtil.toString("dd/MM/mmmm", contrato.getFechaRegistro())%>
            </td>
        </tr>
        <tr>
            <td><b>Documento:</b></td>
            <td style="text-align: right;">
                <a href="<%=contrato.getUri()%>">Decargar</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>