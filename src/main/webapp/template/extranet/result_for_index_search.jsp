<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pe.edu.cibertec.fkarz.core.vehiculo.VehiculoEntity"%>
<%@page import="pe.edu.cibertec.fkarz.util.Error"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<div class="content-panel pn stock card" style="height: 380px;">
		<div id="profile-01"
			style="min-height: 180px; background: url(<%=vehiculo.getFoto()%>); background-repeat: no-repeat; background-size: cover; background-position: center;">
		</div>
		<div class="profile-01 centered">
			<p>RESERVAR</p>
		</div>

		<div class="summary centered" style="background-color: #fff;">
			<strong>MARCA:</strong> <span><%=vehiculo.getMarca()%></span>
		</div>
	</div>
</div>
<%
	}
	}
%>
