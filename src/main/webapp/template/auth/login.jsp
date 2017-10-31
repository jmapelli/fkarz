<%@page import="pe.edu.cibertec.fkarz.util.Error"%>
<%@ include file="../common/header.jsp"%>
<div id="login-page">
	<div class="container">

		<form action="auth" method="post" class="form-login">
			<h2 class="form-login-heading">Iniciar sesión</h2>
			<div class="login-wrap">
				<%
					if (request.getParameter("redirect") != null && !request.getParameter("redirect").isEmpty()) {
				%>
				<input name="redirect" type="hidden"
					value="<%=request.getParameter("redirect")%>">
				<%
					}
				%>
				<input name="username" type="text" class="form-control"
					placeholder="Usuario" autofocus> <br> <input
					name="password" type="password" class="form-control"
					placeholder="Contraseña"> <br>
				<button class="btn btn-theme btn-block" type="submit">
					<i class="fa fa-lock"></i> Iniciar sesión
				</button>
				<br>
				<%
					if (request.getAttribute("error_status") != null
							&& request.getAttribute("error_status").equals(Error.ERROR_STATUS_OK)) {
				%>
				<div class="alert alert-danger alert-dismissable"
					style="margin-bottom: 0">
					<button type="button" class="close" data-dismiss="alert"
						aria-hidden="true">×</button>
					<%=request.getAttribute("error_message")%>
				</div>
				<%
					}
				%>
			</div>

		</form>

	</div>
</div>

<%@ include file="../common/footer.jsp"%>

<script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
<script>
	$.backstretch("assets/img/auth_background.jpg", {
		speed : 500
	});
</script>